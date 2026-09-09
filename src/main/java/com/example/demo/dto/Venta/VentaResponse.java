/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.dto.Venta;

import java.util.List;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @author docas
 */
public class VentaResponse {
    
    private Long id;
    private LocalDateTime fecha;
    private String clienteNombre;
    private BigDecimal total;
    private List<DetalleVentaResponse> detalles;

    public void setId(Long id) {
        this.id = id;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public void setClienteNombre(String clienteNombre) {
        this.clienteNombre = clienteNombre;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public void setDetalles(List<DetalleVentaResponse> detalles) {
        this.detalles = detalles;
    }

    
    

    
}

