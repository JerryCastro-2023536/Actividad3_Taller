package com.jerrycastro.RepuestosAutomotriz.service;

import com.jerrycastro.RepuestosAutomotriz.entity.Proveedores;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProveedorService {
    List<Proveedores> getAllProveedores();
    Proveedores getProveedoresById(Integer id);
    Proveedores saveProveedores(Proveedores proveedores);
    Proveedores updateProveedores(Integer id, Proveedores proveedores);
    void deleteProveedores(Integer id);
}
