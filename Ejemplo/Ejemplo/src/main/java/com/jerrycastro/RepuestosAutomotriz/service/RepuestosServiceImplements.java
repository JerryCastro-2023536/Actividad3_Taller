package com.jerrycastro.RepuestosAutomotriz.service;

import com.jerrycastro.RepuestosAutomotriz.entity.Repuestos;
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
    public Repuestos getRepuestoById(Integer id) {
        Repuestos repuestos = repuestosRepository.findById(id).orElse(null);
        if(repuestos == null){
            throw new IllegalArgumentException("El id no existe");
        }
        return repuestosRepository.findById(id).orElse(null);
    }

    @Override
    public Repuestos saveRepuesto(Repuestos repuestos) {
        return repuestosRepository.save(repuestos);
    }

    @Override
    public Repuestos updateRepuesto(Integer id, Repuestos repuestos) {
        Repuestos repuestos1 = repuestosRepository.findById(id).orElse(null);
        if(repuestos1 != null) {
            repuestos1.setNombre_repuesto(repuestos.getNombre_repuesto());
            repuestos1.setCategoria_repuesto(repuestos.getCategoria_repuesto());
            repuestos1.setPrecio_compra(repuestos.getPrecio_compra());
            repuestos1.setPrecio_venta(repuestos.getPrecio_venta());
            repuestos1.setId_proveedor(repuestos.getId_proveedor());
        }else{
            throw new IllegalArgumentException("El id no existe");
        }
        return repuestosRepository.save(repuestos1);
    }

    @Override
    public void deleteRepuesto(Integer id) {
        Repuestos repuestos = repuestosRepository.findById(id).orElse(null);
        if(repuestos == null){
            throw new IllegalArgumentException("El id no existe");
        }
        repuestosRepository.delete(repuestos);
    }
}
