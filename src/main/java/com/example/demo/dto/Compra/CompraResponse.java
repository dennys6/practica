/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.dto.Compra;

import com.example.demo.dto.DetalleCompra.DetalleCompraResponse;
import com.example.demo.entity.Compra.DetalleCompra;
import com.example.demo.entity.Proveedor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author docas
 */
public class CompraResponse {
    
    private Long id;
    private LocalDateTime fecha;
    private BigDecimal total;
    
    private Long proveedor_id;
    private String proveedorNombre;
    
    private List<DetalleCompraResponse> detalle;

    public CompraResponse(Long id, LocalDateTime fecha, BigDecimal total, Long proveedor_id, 
                          String proveedorNombre, List<DetalleCompraResponse> detalle) {
        this.id = id;
        this.fecha = fecha;
        this.total = total;
        this.proveedor_id = proveedor_id;
        this.proveedorNombre = proveedorNombre;
        this.detalle = detalle;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public Long getProveedor_id() {
        return proveedor_id;
    }

    public String getProveedorNombre() {
        return proveedorNombre;
    }

    public List<DetalleCompraResponse> getDetalle() {
        return detalle;
    }
    
}
