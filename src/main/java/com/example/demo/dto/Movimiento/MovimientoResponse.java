/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.dto.Movimiento;

import com.example.demo.entity.Movimiento.TipoMovimiento;

import java.time.LocalDateTime;


/**
 *
 * @author docas
 */
public class MovimientoResponse {
    
    private Long id;
    private TipoMovimiento tipo;
    private LocalDateTime fecha;
    private Integer cantidad;
    private Long productoId;
    private String nombreProducto;
    

    public MovimientoResponse() {
    }

    public MovimientoResponse(Long id, TipoMovimiento tipo, LocalDateTime fecha, Integer cantidad, Long productoId, String nombreProducto) {
        this.id=id;
        this.tipo = tipo;
        this.fecha=fecha;
        this.productoId = productoId;
        this.cantidad = cantidad;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getFecha() {
        return fecha;
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    
    

    @Override
    public String toString() {
        return "MovimientoRequest{" + "tipo=" + tipo + ", productoId=" + productoId + ", cantidad=" + cantidad + '}';
    }


   
    
    
    
}
