package com.jerrycastro.RepuestosAutomotriz.controller;

import com.jerrycastro.RepuestosAutomotriz.entity.Proveedores;
import com.jerrycastro.RepuestosAutomotriz.service.ProveedorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {
    private final ProveedorService proveedorService;

    public ProveedorController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    @GetMapping
    public List<Proveedores> getAllProveedores(){
        return proveedorService.getAllProveedores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProveedorById(@PathVariable Integer id){
        try{
            Proveedores buscarProveedor = proveedorService.getProveedoresById(id);
            return new ResponseEntity<>(buscarProveedor, HttpStatus.OK);
        }catch(IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Object> createProveedor(@Valid @RequestBody Proveedores proveedores){
        try{
            Proveedores createdproveedor = proveedorService.saveProveedores(proveedores);
            return new ResponseEntity<>(createdproveedor, HttpStatus.CREATED);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProveedor(@PathVariable Integer id, @Valid @RequestBody Proveedores proveedores){
        try{
            Proveedores updatedProveedor = proveedorService.updateProveedores(id, proveedores);
            return new ResponseEntity<>(updatedProveedor, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProveedor(@PathVariable Integer id){
        try{
            proveedorService.deleteProveedores(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
