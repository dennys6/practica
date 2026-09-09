/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.dto.Producto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
/**
 *
 * @author docas
 */
public class ProductoRequest {
     private Long id;
    
    @NotBlank(message="Este campo es obligatorio")
    @Size(max=100, message="No puede superar los 100 caracteres")
    private String nombre;
    
 
    @NotNull(message="Este campo es obligatorio")
    @Size(max=200, message="No puede superar los 200 caracteres")
    private String descripcion;
    
    //No se usa @NotBlank con BigDecimal
    @NotNull(message="Este campo es obligatorio")
    @DecimalMin(value="0.0", inclusive=false, message="No puede ser menor a cero")
    private BigDecimal precio;
    
    /*@NotNull(message="Este campo es obligatorio")
    @Min(value=1, message="Debe ser mayor a cero")
    private Integer stock;*/
    
    @NotNull(message="Este campo es obligatorio")
    private Long categoriaId;
    
    
    public ProductoRequest(){
        
    }
 
     public Long getId() {
        return id;
    }


    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }



    public Long getCategoriaId() {
        return categoriaId;
    }

    
}
