package com.example.demo.service;

import com.example.demo.dto.CategoriaRequest;
import com.example.demo.entity.Categoria;
import com.example.demo.exception.RecursoNotFoundException;
import com.example.demo.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> listarTodas() {
        return categoriaRepository.findAll();
    }

    public Categoria guardar(CategoriaRequest request) {
        Categoria categoria= new Categoria();
        
        categoria.setNombre(request.getNombre());
        categoria.setDescripcion(request.getDescripcion());
        
        return categoriaRepository.save(categoria);
    }
    
    public Categoria buscarPorId(Long id) {
    return categoriaRepository.findById(id)
            .orElseThrow(() -> new RecursoNotFoundException("Categoría no encontrada"));
}
    
    public Categoria actualizar(Long id, Categoria datos) {

    Categoria categoria = categoriaRepository.findById(id)
            .orElseThrow(() -> new RecursoNotFoundException("Categoría no encontrada"));

    categoria.setNombre(datos.getNombre());
    categoria.setDescripcion(datos.getDescripcion());

    return categoriaRepository.save(categoria);
    }
    
    public void eliminar(Long id) {

    if (!categoriaRepository.existsById(id)) {
        throw new RecursoNotFoundException("Categoría no encontrada");
    }

        categoriaRepository.deleteById(id);
    }
}