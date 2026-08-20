/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;
import com.example.demo.Service.ProductoService;
import com.example.demo.dto.ProductoRequest;
import com.example.demo.dto.ProductoResponse;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.web.bind.annotation.*;

/**
 *
 * @author docas
 */

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    
    private final ProductoService productoService;
    
    public ProductoController(ProductoService productoService){
        this.productoService=productoService;
    }
    
    @GetMapping
    public List<ProductoResponse> listar(){
        return productoService.listaProducto();
    }
    
    @GetMapping("/{id}")
    public ProductoResponse buscarPorId(@PathVariable Long id){
        return productoService.buscarProductoPorId(id);
    }
    
    @PostMapping
    public ProductoResponse guardar(@ Valid @RequestBody ProductoRequest request){
        return productoService.guardar(request);
    }
    
    @PutMapping
    public ProductoResponse actualizar( @PathVariable Long id,@Valid @RequestBody ProductoRequest request
            ){
        return productoService.actualizar(id, request);
    }
    
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        productoService.eliminar(id);
    }
    
    
}
