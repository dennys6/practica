/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.entity.Compra;

import com.example.demo.entity.Proveedor;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author docas
 */
@Entity
@Table(name="compra")
public class Compra {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private LocalDateTime fecha;
    
    @Column()
    private BigDecimal total;
    
    @ManyToOne
    @JoinColumn(name="proveedor_id", nullable=false)
    private Proveedor proveedor;
    
    @OneToMany(mappedBy="compra", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<DetalleCompra> detalles=new ArrayList<>();

    public Compra() {
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public List<DetalleCompra> getDetalle() {
        return detalles;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public void setDetalle(List<DetalleCompra> detalle) {
        this.detalles = detalle;
    }
    
    public void agregarDetalle(DetalleCompra det){
        detalles.add(det);
        det.setCompra(this);
    }
    
    
    
   
    
}
