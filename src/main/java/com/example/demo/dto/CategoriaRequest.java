package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CategoriaRequest {

    @NotBlank()
    @Size(max = 80, message="Debe llenar todos los campos")
    private String nombre;
    
    @Size(max = 255, message="No debe superar el límte de 255 caracteres")
    private String descripcion;

    public CategoriaRequest() {
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
}