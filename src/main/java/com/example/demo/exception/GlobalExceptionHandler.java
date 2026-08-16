/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.exception;

/*
Practica SpringBoot Excepciones
*/
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(RecursoNotFoundException.class)
    public ResponseEntity<Map<String, Object>> manejarNoEncontrados(RecursoNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("status", 404, "message", ex.getMessage()
        ));
    }
    
}
