/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.dto.Proveedor;

import jakarta.validation.constraints.*;

public class ProveedorRequest {
    
    @NotBlank(message="Campo obligatorio")
    private String nombre;
    
    @Size(max=100)
    private String correo;
    
    @Size(max=100)
    private String telefono;
            
    @Size(max=100)       
    private String direccion;


    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    
    
    
    
}

