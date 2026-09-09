/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Service;

import com.example.demo.Repository.ProveedorRepository;
import com.example.demo.dto.Proveedor.ProveedorRequest;
import com.example.demo.dto.Proveedor.ProveedorResponse;
import com.example.demo.entity.Proveedor;
import com.example.demo.exception.RecursoNotFoundException;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author docas
 */
@Service
public class ProveedorService {
    
    private ProveedorRepository proveedorRepository;
    
    public List<ProveedorResponse> listar(){
        return proveedorRepository.findAll().stream().map(this::convertirAResponse).toList();
    }
    public List<ProveedorResponse> listarPorId(Long id){
        return proveedorRepository.findById(id).stream().map(this::convertirAResponse).toList();    
        
    } 
    
    public ProveedorResponse guardar(ProveedorRequest r){
        
        Proveedor p=new Proveedor();
        
        p.setNombre(r.getNombre());
        p.setCorreo(r.getCorreo());
        p.setDireccion(r.getDireccion());
        p.setTelefono(r.getTelefono());
        
        Proveedor p2=proveedorRepository.save(p);
        
        return convertirAResponse(p2);
     
    }
    
    public ProveedorResponse actualizar(ProveedorRequest r, Long id){
      
        Proveedor p=proveedorRepository.findById(id).orElseThrow(()->new RecursoNotFoundException("No se encontrado el proveedor"));
        
        p.setNombre(r.getNombre());
        p.setCorreo(r.getCorreo());
        p.setDireccion(r.getDireccion());
        p.setTelefono(r.getTelefono());
        
        Proveedor p2=proveedorRepository.save(p);
        
        return convertirAResponse(p2);
        
    }
    
    public void eliminar(Long id){
        
        if(!proveedorRepository.existsById(id)){
            throw new RecursoNotFoundException("Proveedor no encontrado");
        }
        proveedorRepository.deleteById(id);
    }
    
    public ProveedorResponse convertirAResponse(Proveedor pr){
        
        return new ProveedorResponse(pr.getId(), pr.getNombre(), pr.getCorreo(), pr.getTelefono(), pr.getDireccion());
        
    }
}
