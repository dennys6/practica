/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.dto.Venta;

import java.math.BigDecimal;

/**
 *
 * @author docas
 */
public class DetalleVentaResponse {
    
    private Long id;
    private String productoNombre;
    private BigDecimal precioUnitario;
    private Integer cantidad;
    private BigDecimal subtotal; 

    public void setId(Long id) {
        this.id = id;
    }

    public void setProductoNombre(String productoNombre) {
        this.productoNombre = productoNombre;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    
    
}
