/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Service;

import com.example.demo.Repository.*;
import com.example.demo.dto.Compra.CompraRequest;
import com.example.demo.dto.Compra.CompraResponse;
import com.example.demo.dto.DetalleCompra.DetalleCompraRequest;
import com.example.demo.dto.DetalleCompra.DetalleCompraResponse;
import com.example.demo.entity.Compra.Compra;
import com.example.demo.entity.Compra.DetalleCompra;
import com.example.demo.entity.Producto;
import com.example.demo.exception.RecursoNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author docas
 */

@Service
public class CompraService {
    
    private final CompraRepository compraRepository;
    private final ProductoRepository productoRepository;
    private final ProveedorRepository proveedorRepository;
    private final MovimientoService movimientoService;

    public CompraService(MovimientoService movimientoService, CompraRepository compraRepository, 
           ProductoRepository productoRepository, ProveedorRepository proveedorRepository) {
        this.compraRepository = compraRepository;
        this.productoRepository = productoRepository;
        this.proveedorRepository=proveedorRepository;
        this.movimientoService=movimientoService;
    }
    
    public CompraResponse registrar(CompraRequest req){

        proveedorRepository.findById(req.getProveedor().getId()).orElseThrow(
                                   ()-> new RecursoNotFoundException("El proveedor ingresado no existe"));
    
        Compra compra=new Compra();
        
        List<DetalleCompra> detalleCompra= new ArrayList<>();
        
        BigDecimal total=BigDecimal.ZERO;
        
        DetalleCompra detalleCompraObj=new DetalleCompra();
               
        for (DetalleCompraRequest detalleCompraRequest: req.getDetalle()){
            
            Producto producto=productoRepository.findById(detalleCompraRequest.getProductoId()).orElseThrow(()->new RecursoNotFoundException("Compra no encontrada"));
          
            BigDecimal subtotal=(detalleCompraRequest.getPrecioUnitario()).multiply(BigDecimal.valueOf(detalleCompraRequest.getCantidad()));     
            
            detalleCompraObj.setCantidad(detalleCompraRequest.getCantidad());
            detalleCompraObj.setPrecioUnitario(detalleCompraRequest.getPrecioUnitario());
            total=total.add(subtotal);
            detalleCompra.add(detalleCompraObj);            
                                  
            producto.setStock(producto.getStock()+detalleCompraRequest.getCantidad());
            
            productoRepository.save(producto);
            
            compra.setProveedor(req.getProveedor());
            compra.setFecha(LocalDateTime.now());
            compra.setDetalle(detalleCompra);
            compra.setTotal(total);
            compra.agregarDetalle(detalleCompraObj);
            
            movimientoService.registrarEntradaCompras(producto, detalleCompraRequest.getCantidad(), compra);
              
        }

        Compra guardada=compraRepository.save(compra);
        
        return convertirAResponse(guardada);
    
    }
        

    private CompraResponse convertirAResponse(Compra compra){
      
        List<DetalleCompraResponse> detalleCompra=new ArrayList<>();
       
        
        for(DetalleCompra detalle: compra.getDetalle()){
            
            
            
            DetalleCompraResponse detalleCompraRequest=new DetalleCompraResponse(detalle.getId(), detalle.getCantidad(), 
                                                                        detalle.getPrecioUnitario(), detalle.getProducto().getId(), 
                                                                detalle.getProducto().getNombre(), detalle.getPrecioUnitario());
           
            detalleCompra.add(detalleCompraRequest);
    
        }
        
        CompraResponse compraRequest= new CompraResponse(compra.getId(),compra.getFecha(), compra.getTotal(), 
                                                            compra.getProveedor().getId(), 
                                              compra.getProveedor().getNombre(),  detalleCompra);
        return compraRequest;
        
    }
    
    public void eliminar(Long id){
        if(!compraRepository.existsById(id)){
            throw new RecursoNotFoundException("Compra no encontrada");
        }
        
        compraRepository.deleteById(id);
        
    }
    
    public List<CompraResponse> buscarPorId(Long id){
        return compraRepository.findById(id).stream().map(this::convertirAResponse).toList();
    }
    
     public List<CompraResponse> listar(){
        return compraRepository.findAll().stream().map(this::convertirAResponse).toList();
    }
    
    
            
}
