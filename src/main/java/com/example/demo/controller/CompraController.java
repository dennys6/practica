/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;
import com.example.demo.Repository.CompraRepository;
import com.example.demo.Service.CompraService;
import com.example.demo.dto.Compra.CompraRequest;
import com.example.demo.dto.Compra.CompraResponse;
import com.example.demo.exception.RecursoNotFoundException;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

/**
 *
 * @author docas
 */

@RestController
@RequestMapping("/api/compras")
public class CompraController {
    
    private final CompraService compraService;
    private final CompraRepository compraRepository;

    public CompraController(CompraService compraService, CompraRepository compraRepository) {
        this.compraService = compraService;
        this.compraRepository = compraRepository;
    }
    
    @GetMapping
    public List<CompraResponse> listar(){
        return compraService.listar();
    }
    
    @GetMapping("/{id}")
    public List<CompraResponse> buscarPorId(@PathVariable Long id){
        return compraService.buscarPorId(id);
    }
    
    @PostMapping
    public CompraResponse registrar(@Valid @RequestBody CompraRequest request){
        
        return compraService.registrar(request);
    }
    
    @PutMapping("/{id}")
    public CompraResponse actualizar(@Valid @RequestBody CompraRequest request, @PathVariable Long id){
        if(!compraRepository.existsById(id)){
            throw new RecursoNotFoundException("Compra no encontrada");
        }
        return compraService.registrar(request);
    }
    
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        if(compraRepository.existsById(id)){
            
            compraService.eliminar(id);
            
        }else{
            throw new RecursoNotFoundException("Compra no encontrada");
        }
    }
    
}
