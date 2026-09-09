/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.dto.Venta;

import java.math.BigDecimal;
import jakarta.validation.constraints.*;

/**
 *
 * @author docas
 */
public class DetalleVentaRequest {
    
    @NotNull(message="El producto es obligatorio")
    private Long productoId;
    
    @NotNull(message="El precio es obligatorio")
    private BigDecimal precioUnitario;
    
    @NotNull(message="La cantidad es obligatorio")
    private Integer cantidad;

    public Long getProductoId() {
        return productoId;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public Integer getCantidad() {
        return cantidad;
    }
    
    
    
    
}
