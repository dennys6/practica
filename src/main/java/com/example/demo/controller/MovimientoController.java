/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.Service.MovimientoService;
import com.example.demo.dto.Movimiento.MovimientoRequest;
import com.example.demo.dto.Movimiento.MovimientoResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;



/**
 *
 * @author docas
 */
@RestController
@RequestMapping("/api/movimientos")
public class MovimientoController{
    
    private MovimientoService movimientoService;

    public MovimientoController(MovimientoService movimientoService) {
        this.movimientoService = movimientoService;
    }
    
    
    @PostMapping
    public MovimientoResponse registrar(@Valid @RequestBody MovimientoRequest request){
        return movimientoService.registrar(request);
    }
    
    @GetMapping
    public List<MovimientoResponse> listar(){
        return movimientoService.listarMovimientos();
        
    }
    
    @GetMapping("/productos/{productoId}")
    public List<MovimientoResponse> bucarPorProductoId(Long productoId){
        return movimientoService.listarPorProducto(productoId);
        
    }
    
}
