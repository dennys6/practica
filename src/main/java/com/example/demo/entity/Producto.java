/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.entity;


import jakarta.persistence.*;

import java.math.BigDecimal;
/**
 *
 * @author docas
 */

@Entity
@Table(name="Producto")
public class Producto {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable=false, length=80, unique=true)
    private String nombre;
    
    @Column(nullable=false)
    private String descripcion;
    
    @Column(nullable=false, precision=10, scale=2)
    private BigDecimal precio;
    
   @Column(nullable=false)
    private Integer stock;
    
    @ManyToOne
    @JoinColumn(name="categoria_id", nullable=false)
    private Categoria categoria;
    
    public Producto(){
        
    }
    
    public Producto(String Nombre, BigDecimal precio){
        this.nombre=Nombre;
        this.precio=precio;
    }
    
     public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

}
