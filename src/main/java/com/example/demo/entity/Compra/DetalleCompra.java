/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.entity.Compra;

import com.example.demo.entity.Compra.Compra;
import com.example.demo.entity.Producto;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import java.math.BigDecimal;
/**
 *
 * @author docas
 */
@Entity
@Table(name="detalle_compra")
public class DetalleCompra {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable=false)
    private Integer cantidad;
    
    @Column(nullable=false, precision=10, scale=2)
    @DecimalMin(value="0.0")
    private BigDecimal precioUnitario;

    @ManyToOne
    @JoinColumn(name="producto_id", nullable=false)
    private Producto producto;
    
    @ManyToOne
    @JoinColumn(name="compra_id", nullable=false)
    private Compra compra;

    public DetalleCompra() {
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

    public Producto getProducto() {
        return producto;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }
    
}