package com.jerrycastro.RepuestosAutomotriz.service;

import com.jerrycastro.RepuestosAutomotriz.entity.Empleados;
import com.jerrycastro.RepuestosAutomotriz.entity.Proveedores;
import com.jerrycastro.RepuestosAutomotriz.repository.ProveedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedoresServiceImplements implements ProveedorService{
    private final ProveedorRepository proveedorRepository;

    public ProveedoresServiceImplements(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    @Override
    public List<Proveedores> getAllProveedores() {
        return proveedorRepository.findAll();
    }

    @Override
    public Proveedores getProveedoresById(Integer id) {
        Proveedores proveedores = proveedorRepository.findById(id).orElse(null);
        if(proveedores == null){
            throw new IllegalArgumentException("El id no existe");
        }
        return proveedorRepository.findById(id).orElse(null);
    }

    @Override
    public Proveedores saveProveedores(Proveedores proveedores) {
        return proveedorRepository.save(proveedores);
    }

    @Override
    public Proveedores updateProveedores(Integer id, Proveedores proveedores) {
        Proveedores proveedores1 = proveedorRepository.findById(id).orElse(null);
        if(proveedores1 != null){
            proveedores1.setNombre_proveedor(proveedores.getNombre_proveedor());
            proveedores1.setTelfono_proveedor(proveedores.getTelfono_proveedor());
            proveedores1.setDireccion(proveedores.getDireccion());
            proveedores1.setEmail_proveedor(proveedores.getEmail_proveedor());
        }else{
            throw new IllegalArgumentException("El id no existe");
        }
        return proveedorRepository.save(proveedores1);
    }

    @Override
    public void deleteProveedores(Integer id) {
        Proveedores proveedores = proveedorRepository.findById(id).orElse(null);
        if(proveedores == null){
            throw new IllegalArgumentException("El id no existe");
        }
        proveedorRepository.delete(proveedores) ;
    }
}
