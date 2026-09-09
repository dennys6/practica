/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.dto.Venta;

import java.util.List;
import jakarta.validation.constraints.*;
import java.util.ArrayList;

/**
 *
 * @author docas
 */
public class VentaRequest {
    
    @NotNull(message="El cliente es obligatorio")
    private Long clienteId;
    
    @NotNull(message="Detalle incorrecto")
    private List<DetalleVentaRequest> detalles=new ArrayList<>();

    public Long getClienteId() {
        return clienteId;
    }

    public List<DetalleVentaRequest> getDetalles() {
        return detalles;
    }
    
}
