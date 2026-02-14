package com.jerrycastro.RepuestosAutomotriz.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import java.sql.SQLIntegrityConstraintViolationException;


import java.util.Map;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleValidation(ResourceNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", e.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> validarNotaciones(MethodArgumentNotValidException e){
        return ResponseEntity.badRequest().body(Map.of("Error", e.getMessage()));
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<Object> validarLlaveForanea(SQLIntegrityConstraintViolationException e){
        return ResponseEntity.badRequest().body(Map.of("Error", "No existe la llave foranea"));
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<Object> validarFormato(HttpMediaTypeNotSupportedException e){
        return ResponseEntity.badRequest().body(Map.of("Error", "El archivo enviado no es tipo JSON"));
    }

    @ExceptionHandler(InvalidEmailException.class)
    public ResponseEntity<Object> validarFormatoCorreo(InvalidEmailException e){
        return ResponseEntity.badRequest().body(Map.of("Mensaje", e.getMessage()));
    }

    @ExceptionHandler(ExistsEmailException.class)
    public  ResponseEntity<Object> validarCorreoExistente(ExistsEmailException e){
        return  ResponseEntity.badRequest().body(Map.of("Mensaje", e.getMessage()));
    }

    @ExceptionHandler(InvalidNumberException.class)
    public ResponseEntity<Object> validarNumerosPositivos(InvalidNumberException e){
        return ResponseEntity.badRequest().body(Map.of("Error", e.getMessage()));
    }

    @ExceptionHandler(InvalidQuantityException.class)
    public ResponseEntity<Object> validarCifras(InvalidQuantityException e){
        return ResponseEntity.badRequest().body(Map.of("Error", e.getMessage()));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleInvalidType(HttpMessageNotReadableException ex) {
        return ResponseEntity.badRequest().body(Map.of("Error", "Tipo de dato incorrecto"));
    }

}
