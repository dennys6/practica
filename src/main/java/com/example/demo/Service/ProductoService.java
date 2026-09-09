/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Service;

import com.example.demo.Repository.ProductoRepository;
import com.example.demo.dto.Producto.ProductoRequest;
import com.example.demo.dto.Producto.ProductoResponse;
import com.example.demo.entity.Categoria;
import com.example.demo.entity.Producto;
import com.example.demo.repository.CategoriaRepository;
import org.springframework.stereotype.Service;
import com.example.demo.exception.RecursoNotFoundException;

import java.util.List;

@Service
public class ProductoService {
    
    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;
    
    public ProductoService(ProductoRepository productoRepository,
            CategoriaRepository categoriaRepository){
        this.productoRepository=productoRepository;
        this.categoriaRepository=categoriaRepository;
        
    }
    
    public List<ProductoResponse> listaProducto(){
        return productoRepository.findAll().stream().map(this::convertirAResponse).toList();
    }
    
    public ProductoResponse buscarProductoPorId(Long Id){
       Producto producto=productoRepository.findById(Id).orElseThrow(()-> new RuntimeException("No encontrado"));
    
        return convertirAResponse(producto);
    
    }
    
    
    public ProductoResponse guardar(ProductoRequest request){
        
        Categoria categoria=categoriaRepository.findById(request.getCategoriaId()).orElseThrow(()-> new RecursoNotFoundException("No se encontró tal categoría"));
        
        Producto producto=new Producto();
        
        producto.setNombre(request.getNombre());
        producto.setDescripcion(request.getDescripcion());
        producto.setStock(0);
        producto.setPrecio(request.getPrecio());
        producto.setCategoria(categoria);
        
        Producto productoGuardado=productoRepository.save(producto);
        
        return convertirAResponse(productoGuardado);
        
    }
    
    public void eliminar(Long id){
        if(!productoRepository.existsById(id)){
            throw new RecursoNotFoundException("no se ha encontrado el producto");
        }
         productoRepository.deleteById(id);
        
    }
    
    public ProductoResponse actualizar(Long id, ProductoRequest request){
        
        Producto producto=productoRepository.findById(id).orElseThrow(()->new RecursoNotFoundException("No se ha encontrado el producto"));
    
        Categoria categoria=categoriaRepository.findById(request.getCategoriaId()).orElseThrow(()->new RecursoNotFoundException("No se ha encontrado la categoría"));
    
     
        producto.setDescripcion(request.getDescripcion());
        producto.setNombre(request.getNombre());
        producto.setPrecio(request.getPrecio());
        //producto.setStock(request.getStock());
        producto.setCategoria(categoria);
        
        Producto productoActualizado =productoRepository.save(producto);
        
        return convertirAResponse(productoActualizado);
        
        
    
    
    }
    
    private ProductoResponse convertirAResponse(Producto producto){
        
        return new ProductoResponse(producto.getId(),                                 
                                    producto.getNombre(),
                                    producto.getDescripcion(),
                                    producto.getPrecio(),
                                    producto.getStock(),
                                    producto.getCategoria().getId(),
                                    producto.getCategoria().getNombre()
        );
    }
    
}
