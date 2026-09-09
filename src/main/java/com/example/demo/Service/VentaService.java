/* * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Service;

import com.example.demo.Repository.ClienteRepository;
import com.example.demo.Repository.DetalleFacturaRepository;
import com.example.demo.Repository.ProductoRepository;
import com.example.demo.Repository.VentaRepository;
import com.example.demo.dto.Venta.DetalleVentaRequest;
import com.example.demo.dto.Venta.DetalleVentaResponse;
import com.example.demo.dto.Venta.VentaRequest;
import com.example.demo.dto.Venta.VentaResponse;
import com.example.demo.entity.Producto;
import com.example.demo.entity.Venta.DetalleFactura;
import com.example.demo.entity.Venta.Venta;
import com.example.demo.exception.RecursoNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author docas
 */

@Service
public class VentaService {
    
    private VentaRepository ventaRepository;
    private DetalleFacturaRepository detalleFacturaRepository;
    private ProductoRepository productoRepository;
    private ClienteRepository clienteRepository;
    
    public VentaService(VentaRepository ventaRepository, DetalleFacturaRepository detalleFacturaRepository
                        , ProductoRepository productoRepository, ClienteRepository clienteRepository) {
        this.ventaRepository = ventaRepository;
        this.detalleFacturaRepository = detalleFacturaRepository;
        this.productoRepository = productoRepository;
        this.clienteRepository=clienteRepository;
    }
    
    @Transactional
    public VentaResponse registrar(VentaRequest request){
        
        List<DetalleFactura> detallesVenta=new ArrayList<>();
        
        BigDecimal total=BigDecimal.ZERO;
        
        
        
        for(DetalleVentaRequest detalleVentaRequest: request.getDetalles()){
            
            DetalleFactura detalleFactura=new DetalleFactura();
           
            Producto producto = productoRepository.findById(detalleVentaRequest.getProductoId()).orElseThrow(
            ()->new RecursoNotFoundException("Producto no encontrado"));
            
            BigDecimal subtotal=detalleVentaRequest.getPrecioUnitario()
                    .multiply(BigDecimal.valueOf(detalleVentaRequest.getCantidad()));
            
            total=total.add(subtotal);
            
            detalleFactura.setCantidad(detalleVentaRequest.getCantidad());
            detalleFactura.setPrecioUnitario(detalleVentaRequest.getPrecioUnitario());
            detalleFactura.setProducto(producto);
            
            detallesVenta.add(detalleFactura);       
            
    }
        
    Venta venta=new Venta();
    venta.setDetalle(detallesVenta);
    venta.setPrecio(total);
    
    Venta guardada=ventaRepository.save(venta);

    
    return convertirAResponse(guardada);

    }
    
   
public VentaResponse convertirAResponse(Venta venta){
    
    List<DetalleVentaResponse> detallesVentaResponse=new ArrayList<>();
    
    BigDecimal total=BigDecimal.ZERO;
    
    for (DetalleFactura detalleVenta:venta.getDetalle()){
        
        BigDecimal subtotal=detalleVenta.getPrecioUnitario().
                multiply(BigDecimal.valueOf(detalleVenta.getCantidad()));
        
        
        DetalleVentaResponse detalleVentaR=new DetalleVentaResponse();
        detalleVentaR.setCantidad(detalleVenta.getCantidad());
        detalleVentaR.setId(detalleVenta.getId());
        detalleVentaR.setPrecioUnitario(detalleVenta.getPrecioUnitario());
        detalleVentaR.setProductoNombre(detalleVenta.getProducto().getNombre());
        detalleVentaR.setSubtotal(subtotal);
        
        total=total.add(subtotal);
        
        
        detallesVentaResponse.add(detalleVentaR);

    }
    
    VentaResponse ventaResponse=new VentaResponse();
    ventaResponse.setClienteNombre(venta.getCliente().getNombre());
    ventaResponse.setFecha(LocalDateTime.now());
    ventaResponse.setId(venta.getId());
    ventaResponse.setDetalles(detallesVentaResponse);
    ventaResponse.setTotal(total);
    
    return ventaResponse;
        
    
    
}
}
