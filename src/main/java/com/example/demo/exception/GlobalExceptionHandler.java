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
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Map;
import java.util.HashMap;

@RestControllerAdvice

public class GlobalExceptionHandler {
    
    @ExceptionHandler(RecursoNotFoundException.class)
    public ResponseEntity<Map<String, Object>> manejarNoEncontrados(RecursoNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("status", 404, "message", ex.getMessage()
        ));
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> manejarValidaciones(MethodArgumentNotValidException ex){
        
       Map<String, String> errores=new HashMap<>();
       
       ex.getBindingResult().getFieldErrors().forEach(error->errores.put(error.getField(), error.getDefaultMessage()));
               
       Map<String, Object> respuesta= new HashMap<>();
       
       respuesta.put("status", 400);
       respuesta.put("message", "Error de validación");
       respuesta.put("errors", errores);
          
       return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuesta);

    }
    
}
