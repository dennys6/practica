/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Service;

import com.example.demo.Repository.MovimientoRepository;
import com.example.demo.Repository.ProductoRepository;
import com.example.demo.dto.Movimiento.MovimientoRequest;
import com.example.demo.dto.Movimiento.MovimientoResponse;
import com.example.demo.entity.Compra.Compra;
import com.example.demo.entity.Movimiento.Movimiento;
import com.example.demo.entity.Movimiento.OrigenMovimiento;
import com.example.demo.entity.Producto;
import com.example.demo.entity.Movimiento.TipoMovimiento;
import com.example.demo.exception.RecursoNotFoundException;
import com.example.demo.exception.StockInsuficienteException;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author docas
 */

@Service
public class MovimientoService {
    
    private final MovimientoRepository movimientoRepository;
    private final ProductoRepository productoRepository;

    public MovimientoService(MovimientoRepository movimientoRepository, ProductoRepository productoRepository) {
        this.movimientoRepository = movimientoRepository;
        this.productoRepository = productoRepository;
    }   
    
    
   @Transactional
   public MovimientoResponse registrar(MovimientoRequest request){
       
       Producto producto=productoRepository.findById(request.getProductoId()).orElseThrow(()-> new RecursoNotFoundException
                                ("No existe el producto"));
       
       if (request.getTipo()==TipoMovimiento.ENTRADA){

           producto.setStock(producto.getStock()+request.getCantidad());
           
           
       } else if (request.getTipo()==TipoMovimiento.SALIDA){
           
           if(producto.getStock()>request.getCantidad()){
               
               producto.setStock(producto.getStock()-request.getCantidad());
           
           }else{
               throw new StockInsuficienteException("Su pedido excede existencias");
           }
           
       }
       productoRepository.save(producto);
       
       Movimiento movimiento=new Movimiento();
       movimiento.setCantidad(request.getCantidad());
       movimiento.setProducto(producto);
       movimiento.setTipo(request.getTipo());
       movimiento.setFecha(LocalDateTime.now());
       
       Movimiento guardado=movimientoRepository.save(movimiento);
       
       return convertirAResponse(guardado);
   
   } 
   
   public List<MovimientoResponse> listarMovimientos(){
       return movimientoRepository.findAll().stream().map(this::convertirAResponse).toList();
   }
   
   public List<MovimientoResponse> buscarPorId(Long id){
       return movimientoRepository.findById(id).stream().map(this::convertirAResponse).toList();
       
         }
   
   public List<MovimientoResponse> listarPorProducto(Long productoId){
       if (!movimientoRepository.existsById(productoId)){
           throw new RecursoNotFoundException("Producto no encontrado");
       }
        return movimientoRepository.findAll().stream().map(this::convertirAResponse).toList();
   }
      
    private MovimientoResponse convertirAResponse(Movimiento mov){
        
        return new MovimientoResponse(mov.getId(), 
                                      mov.getTipo(), 
                                      mov.getFecha(), 
                                      mov.getCantidad(),
                                      mov.getProducto().getId(),
                                      mov.getProducto().getNombre());
    }
    
    public void registrarEntradaCompras(Producto producto, Integer cantidad, Compra compra){
        
        producto.setStock(producto.getStock()+cantidad);
        productoRepository.save(producto);
        
        Movimiento movimiento=new Movimiento();
        
        movimiento.setCantidad(cantidad);
        movimiento.setFecha(LocalDateTime.now());
        movimiento.setProducto(producto);
        movimiento.setTipo(TipoMovimiento.ENTRADA);
        movimiento.setOrigen(OrigenMovimiento.COMPRA);
        movimiento.setCompra(compra);
        
        movimientoRepository.save(movimiento);    
    }
        
}
