package com.example.demo.controller;

import com.example.demo.dto.CategoriaRequest;
import com.example.demo.entity.Categoria;
import com.example.demo.service.CategoriaService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public List<Categoria> listar() {
        return categoriaService.listarTodas();
    }
    
    @GetMapping("/{id}")
    public Categoria buscarPorId(@PathVariable Long id) {
        return categoriaService.buscarPorId(id);
    }

    @PostMapping
    public Categoria guardar(@ Valid @RequestBody CategoriaRequest request) {
        return categoriaService.guardar(request);
    }
    
    @PutMapping("/{id}")
    public Categoria actualizar(
        @PathVariable Long id,
        @RequestBody Categoria categoria) {

        return categoriaService.actualizar(id, categoria);
    }
    
    @DeleteMapping("/{id}")
        public void eliminar(@PathVariable Long id) {
        categoriaService.eliminar(id);
}
}