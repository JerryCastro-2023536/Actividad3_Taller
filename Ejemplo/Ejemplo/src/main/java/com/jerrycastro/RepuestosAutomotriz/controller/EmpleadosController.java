package com.jerrycastro.RepuestosAutomotriz.controller;

import com.jerrycastro.RepuestosAutomotriz.model.Empleados;
import com.jerrycastro.RepuestosAutomotriz.service.EmpleadosService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadosController {
    private final EmpleadosService empleadoService;

    public EmpleadosController(EmpleadosService empleadoService) {
        this.empleadoService = empleadoService;
    }
    
    @GetMapping
    public List<Empleados> getAllEmpleados(){
        return empleadoService.getAllEmpleados();
    }

    @PostMapping
    public ResponseEntity <Object> createEmpleado (@Valid @RequestBody Empleados empleados){
        try{
            Empleados createdEmpleado = empleadoService.saveEmpleado(empleados);
            return new ResponseEntity<>(createdEmpleado, HttpStatus.CREATED);
        }catch(IllegalArgumentException e){
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
