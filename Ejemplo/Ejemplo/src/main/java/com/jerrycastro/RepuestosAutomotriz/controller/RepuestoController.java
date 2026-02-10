package com.jerrycastro.RepuestosAutomotriz.controller;

import com.jerrycastro.RepuestosAutomotriz.entity.Repuestos;
import com.jerrycastro.RepuestosAutomotriz.service.RepuestoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/repuesto")
public class RepuestoController {
    private final RepuestoService repuestoService;

    public RepuestoController(RepuestoService repuestoService) {
        this.repuestoService = repuestoService;
    }

    @GetMapping
    public List<Repuestos> getAllRepuestos(){
        return repuestoService.getAllRepuestos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getAllRepuestoById(@PathVariable Integer id){
        try{
            Repuestos buscarRepuesto = repuestoService.getRepuestoById(id);
            return new ResponseEntity<>(buscarRepuesto, HttpStatus.OK);
        }catch(IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Object> createRepuesto(@Valid @RequestBody Repuestos repuestos){
        try{
            Repuestos createdRepuesto = repuestoService.saveRepuesto(repuestos);
            return new ResponseEntity<>(createdRepuesto, HttpStatus.CREATED);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateRepuesto(@PathVariable Integer id, @Valid @RequestBody Repuestos repuestos){
        try{
            Repuestos updatedRepuesto = repuestoService.updateRepuesto(id, repuestos);
            return new ResponseEntity<>(updatedRepuesto, HttpStatus.OK);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteRepuesto(@PathVariable Integer id){
        try{
            repuestoService.deleteRepuesto(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
