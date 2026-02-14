package com.jerrycastro.RepuestosAutomotriz.controller;

import com.jerrycastro.RepuestosAutomotriz.entity.Ventas;
import com.jerrycastro.RepuestosAutomotriz.service.VentasService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentasController {
    private final VentasService ventasService;

    public VentasController(VentasService ventasService) {
        this.ventasService = ventasService;
    }

    @GetMapping
    public List<Ventas> getAllVentas(){
        return ventasService.getAllVentas();
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Object> getVentaById(@PathVariable Integer id){
        try{
            Ventas buscarVenta = ventasService.getVentasById(id);
            return new ResponseEntity<>(buscarVenta, HttpStatus.OK);
        }catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Object> createVenta(@Valid @RequestBody Ventas ventas){
        try{
            Ventas createdVenta = ventasService.saveVentas(ventas);
            return new ResponseEntity<>(createdVenta, HttpStatus.CREATED);
        }catch(IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateVenta(@PathVariable Integer id, @Valid @RequestBody Ventas ventas){
        try{
            Ventas updatedVenta = ventasService.updateVentas(id, ventas);
            return new ResponseEntity<>(updatedVenta, HttpStatus.OK);
        }catch(IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Object> deleteVenta(@PathVariable Integer id){
        try{
            ventasService.deleteVentas(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
