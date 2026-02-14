package com.jerrycastro.RepuestosAutomotriz.service;

import com.jerrycastro.RepuestosAutomotriz.entity.Repuestos;
import com.jerrycastro.RepuestosAutomotriz.exception.InvalidNumberException;
import com.jerrycastro.RepuestosAutomotriz.exception.InvalidQuantityException;
import com.jerrycastro.RepuestosAutomotriz.exception.ResourceNotFoundException;
import com.jerrycastro.RepuestosAutomotriz.repository.RepuestosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepuestosServiceImplements implements RepuestoService{

    private final RepuestosRepository repuestosRepository;

    public RepuestosServiceImplements(RepuestosRepository repuestosRepository) {
        this.repuestosRepository = repuestosRepository;
    }

    @Override
    public List<Repuestos> getAllRepuestos() {
        return repuestosRepository.findAll();
    }

    @Override
    public Repuestos getRepuestoById(Integer id){
        return repuestosRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("El id buscado no existe: " + id));
    }

    @Override
    public Repuestos saveRepuesto(Repuestos repuestos) {
        if(repuestos.getPrecio_compra() <= 0 || repuestos.getPrecio_venta() <= 0){
            throw new InvalidNumberException("El valores de venta y compra son menores o igual a 0");
        }
        if(repuestos.getPrecio_compra() > repuestos.getPrecio_venta()){
            throw new InvalidQuantityException("El precio de compra es mayor al de venta");
        }

        return repuestosRepository.save(repuestos);
    }

    @Override
    public Repuestos updateRepuesto(Integer id, Repuestos repuestos) {
        Repuestos repuestos1 = repuestosRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("El id buscado no existe: " + id));

        repuestos1.setNombre_repuesto(repuestos.getNombre_repuesto());
        repuestos1.setCategoria_repuesto(repuestos.getCategoria_repuesto());
        repuestos1.setPrecio_compra(repuestos.getPrecio_compra());
        repuestos1.setPrecio_venta(repuestos.getPrecio_venta());
        repuestos1.setId_proveedor(repuestos.getId_proveedor());

        if(repuestos1.getPrecio_compra() <= 0 || repuestos1.getPrecio_venta() <= 0){
            throw new InvalidNumberException("El valores de venta y compra son menores o igual a 0");
        }
        if(repuestos1.getPrecio_compra() > repuestos1.getPrecio_venta()){
            throw new InvalidQuantityException("El precio de compra es mayor al de venta");
        }

        return repuestosRepository.save(repuestos1);
    }

    @Override
    public void deleteRepuesto(Integer id) {
        Repuestos repuestos = repuestosRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("El id buscado no existe: " + id));

        repuestosRepository.delete(repuestos);
    }
}
