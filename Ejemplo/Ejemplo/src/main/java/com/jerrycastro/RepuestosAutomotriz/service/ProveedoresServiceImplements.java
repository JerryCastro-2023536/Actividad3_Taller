package com.jerrycastro.RepuestosAutomotriz.service;

import com.jerrycastro.RepuestosAutomotriz.entity.Proveedores;
import com.jerrycastro.RepuestosAutomotriz.exception.ExistsEmailException;
import com.jerrycastro.RepuestosAutomotriz.exception.InvalidEmailException;
import com.jerrycastro.RepuestosAutomotriz.exception.ResourceNotFoundException;
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
        return proveedorRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("El id buscado no existe"));
    }

    @Override
    public Proveedores saveProveedores(Proveedores proveedores) {
        String correo = proveedores.getEmail_proveedor();
        List<Proveedores> proveedores1 = proveedorRepository.findAll();

        for(Proveedores e : proveedores1){
            if(correo.equals(e.getEmail_proveedor())){
                throw new ExistsEmailException("El correo ya ha sido registrado");
            }
        }

        if (!(proveedores.getEmail_proveedor().contains("@gmail.com") ||
                proveedores.getEmail_proveedor().contains("@yahoo.com")
                || proveedores.getEmail_proveedor().contains("@outlook.com"))) {
            throw new InvalidEmailException("El correo tiene un formato invalido");
        }
        return proveedorRepository.save(proveedores);
    }

    @Override
    public Proveedores updateProveedores(Integer id, Proveedores proveedores) {
        Proveedores proveedores1 = proveedorRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("El id buscado no existe: " + id));

        proveedores1.setNombre_proveedor(proveedores.getNombre_proveedor());
        proveedores1.setTelfono_proveedor(proveedores.getTelfono_proveedor());
        proveedores1.setDireccion(proveedores.getDireccion());
        proveedores1.setEmail_proveedor(proveedores.getEmail_proveedor());

        List<Proveedores> proveedores2 = proveedorRepository.findAll();

        for(Proveedores e : proveedores2){
            if(proveedores1.getEmail_proveedor().equals(e.getEmail_proveedor())){
                throw new ExistsEmailException("El correo ya ha sido registrado");
            }
        }

        if(!(proveedores1.getEmail_proveedor().contains("@gmail.com")||
                proveedores.getEmail_proveedor().contains("@yahoo.com")
                || proveedores.getEmail_proveedor().contains("@outlook.com"))){
            throw new InvalidEmailException("El correo actualizado tiene un formato invalido");
        }
        return proveedorRepository.save(proveedores1);
    }

    @Override
    public void deleteProveedores(Integer id) {
        Proveedores proveedores = proveedorRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("El id buscado no existe: " + id));
        proveedorRepository.delete(proveedores) ;
    }
}
