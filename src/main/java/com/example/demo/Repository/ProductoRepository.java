/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.Repository;

import com.example.demo.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author docas
 */
public interface ProductoRepository extends JpaRepository<Producto, Long>{
}
