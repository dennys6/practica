/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.Service.ProveedorService;
import com.example.demo.dto.Proveedor.ProveedorRequest;
import com.example.demo.dto.Proveedor.ProveedorResponse;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {
    
    private final ProveedorService proveedorService;

    public ProveedorController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }
    

    @GetMapping
    public List<ProveedorResponse> listar(){
        return proveedorService.listar();
    }
    
    @GetMapping("/{id}")
    public List<ProveedorResponse> listarPorId(@PathVariable Long id){
        return proveedorService.listarPorId(id);
    } 
    
    @PostMapping
    public ProveedorResponse guardar(@Valid @RequestBody ProveedorRequest r){
        return proveedorService.guardar(r);
    }
    
    @PutMapping("/{id}")
    public ProveedorResponse actualizar(@Valid @RequestBody ProveedorRequest r, @PathVariable Long id){
      return proveedorService.actualizar(r, id);
    }
    
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        proveedorService.eliminar(id);
    }
    
  
}
