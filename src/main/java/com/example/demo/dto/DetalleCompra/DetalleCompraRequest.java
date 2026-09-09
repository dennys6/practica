/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.dto.DetalleCompra;

import com.example.demo.entity.Producto;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;


public class DetalleCompraRequest {
    
    @NotNull(message="Input inválido")
    private Long productoId;
    
    @Min(value=0, message="Input inválido")
    @NotNull(message="Input inválido")
    private Integer cantidad;
    
    @NotNull(message="Input inválido")
    @DecimalMin(value="0.0", message="Input inválido")
    private BigDecimal precioUnitario;
    

    public DetalleCompraRequest() {
    }

    public Long getProductoId() {
        return productoId;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    
   
   
    
}


