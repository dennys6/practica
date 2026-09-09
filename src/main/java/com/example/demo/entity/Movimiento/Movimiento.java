/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.entity.Movimiento;


import com.example.demo.entity.Movimiento.OrigenMovimiento;
import com.example.demo.entity.Compra.Compra;
import jakarta.persistence.*;

import java.time.LocalDateTime;

import com.example.demo.entity.Movimiento.TipoMovimiento;
import com.example.demo.entity.Producto;
/**
 *
 * @author docas
 */

@Entity
@Table(name="movimiento")
public class Movimiento {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable=false, length=10)
    private TipoMovimiento tipo;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable=false, length=10)
    private OrigenMovimiento origen;
    
    @Column(nullable=false)
    private Integer cantidad;
    
    @Column(nullable=false)
    private LocalDateTime fecha;
    
    @ManyToOne
    @JoinColumn(name="producto_id", nullable=false)
    private Producto producto;
    
    @ManyToOne
    @JoinColumn(name="compra_id")
    private Compra compra;

    public Movimiento() {
    }

    public Movimiento(Long id, TipoMovimiento tipo, Integer cantidad, LocalDateTime fecha, Producto producto) {
        this.id = id;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.producto = producto;
    }

    public Long getId() {
        return id;
    }

    public TipoMovimiento getTipo() {
        return tipo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public Producto getProducto() {
        return producto;
    }

    public OrigenMovimiento getOrigen() {
        return origen;
    }

    public void setId(Long id) {
        this.id = id;
    }
    

    public void setTipo(TipoMovimiento tipo) {
        this.tipo = tipo;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setOrigen(OrigenMovimiento origen) {
        this.origen = origen;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }
  
    
}
