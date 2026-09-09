/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.dto.DetalleCompra;

import java.math.BigDecimal;


public class DetalleCompraResponse {
    
    private Long id;
    private Integer cantidad;
    private BigDecimal precioUnitario;
    
    private Long productoId;
    private String productoNombre;    
    
    private BigDecimal subTotal;

    public DetalleCompraResponse(Long id, Integer cantidad, BigDecimal precioUnitario, Long productoId, String productoNombre, BigDecimal subTotal) {
        this.id = id;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.productoId = productoId;
        this.productoNombre = productoNombre;
        this.subTotal = subTotal;
    }

    public Long getId() {
        return id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public Long getProductoId() {
        return productoId;
    }

    public String getProductoNombre() {
        return productoNombre;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

   
   
   
    
}

