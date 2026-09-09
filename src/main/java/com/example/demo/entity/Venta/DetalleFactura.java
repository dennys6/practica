/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.entity.Venta;

import com.example.demo.entity.Producto;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

/**
 *
 * @author docas
 */
@Entity
@Table(name="detalle_factura")
public class DetalleFactura {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable=false)
    @DecimalMin(value="0.1", inclusive=true)
    private BigDecimal precioUnitario;
    
    @Column(nullable=false)
    @Min(value=0)
    private Integer cantidad;
    
    @ManyToOne
    @JoinColumn(name="producto_id")
    private Producto producto;
    
    @ManyToOne
    @JoinColumn(name="venta_id")
    private Venta venta;

    public Long getId() {
        return id;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

}
