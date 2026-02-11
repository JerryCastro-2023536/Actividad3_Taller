package com.jerrycastro.RepuestosAutomotriz.service;

import com.jerrycastro.RepuestosAutomotriz.entity.Ventas;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface VentasService {
    List<Ventas> getAllVentas();
    Ventas getVentasById(Integer id);
    Ventas saveVentas(Ventas ventas);
    Ventas updateVentas(Integer id, Ventas ventas);
    void deleteVentas(Integer id);
}
