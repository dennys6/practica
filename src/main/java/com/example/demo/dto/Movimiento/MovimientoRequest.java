package com.example.demo.dto.Movimiento;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import com.example.demo.entity.Producto;
import com.example.demo.entity.Movimiento.TipoMovimiento;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author docas
 */
public class MovimientoRequest {
    
    @NotNull(message="Tipo inválido")
    private TipoMovimiento tipo;
    
    @NotNull(message="Dato inválido")
    private Long productoId;
    
    
    @NotNull(message="Cantidad inválido")
    @Min(value=1, message="Cantidad debe ser entero mayor a cero")
    private Integer cantidad;

    public MovimientoRequest() {
    }

    public MovimientoRequest(TipoMovimiento tipo, Long productoId, Integer cantidad) {
        this.tipo = tipo;
        this.productoId = productoId;
        this.cantidad = cantidad;
    }

    public TipoMovimiento getTipo() {
        return tipo;
    }

    public Long getProductoId() {
        return productoId;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setTipo(TipoMovimiento tipo) {
        this.tipo = tipo;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "MovimientoRequest{" + "tipo=" + tipo + ", productoId=" + productoId + ", cantidad=" + cantidad + '}';
    }

}
