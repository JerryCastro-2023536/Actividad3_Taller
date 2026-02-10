package com.jerrycastro.RepuestosAutomotriz.service;

import com.jerrycastro.RepuestosAutomotriz.entity.Repuestos;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RepuestoService {
    List<Repuestos> getAllRepuestos();
    Repuestos getRepuestoById(Integer id);
    Repuestos saveRepuesto(Repuestos repuestos);
    Repuestos updateRepuesto(Integer id, Repuestos repuestos);
    void deleteRepuesto(Integer id);
}
