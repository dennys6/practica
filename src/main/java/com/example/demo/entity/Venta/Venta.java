/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.entity.Venta;

import com.example.demo.entity.Cliente;
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
@Table(name="venta")
public class Venta {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private LocalDateTime fecha;

    @Column(nullable=false)
    private BigDecimal total;
    
    @ManyToOne
    @JoinColumn(name="cliente_id")
    private Cliente cliente;
    
    @OneToMany()
    private List<DetalleFactura> detalles=new ArrayList<>();

    public Long getId() {
        return id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public BigDecimal getPrecio() {
        return total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<DetalleFactura> getDetalle() {
        return detalles;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public void setPrecio(BigDecimal total) {
        this.total = total;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setDetalle(List<DetalleFactura> detalles) {
        this.detalles = detalles;
    }
    
    public void agregarDetalle(DetalleFactura detalle){
        detalles.add(detalle);
        detalle.setVenta(this);
        
    }
    
    
    
            
}
