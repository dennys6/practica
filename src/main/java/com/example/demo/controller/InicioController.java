package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InicioController {

    @GetMapping("/mensajePrueba")
    public String inicio() {
        return "Sistema de Inventario funcionando";
    }
}
