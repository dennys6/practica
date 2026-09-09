/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.Repository;

import com.example.demo.entity.Movimiento.Movimiento;
import com.example.demo.entity.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MovimientoRepository extends JpaRepository<Movimiento, Long>{
    
    List<Producto> findByProductoId(Long productoId);
}
