package com.jerrycastro.RepuestosAutomotriz.service;

import com.jerrycastro.RepuestosAutomotriz.entity.Ventas;
import com.jerrycastro.RepuestosAutomotriz.repository.VentaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentasServiceImplements implements VentasService{
    private final VentaRepository ventaRepository;

    public VentasServiceImplements(VentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    @Override
    public List<Ventas> getAllVentas() {
        return ventaRepository.findAll();
    }

    @Override
    public Ventas getVentasById(Integer id) {
        Ventas ventas = ventaRepository.findById(id).orElse(null);
        if(ventas == null){
            throw new IllegalArgumentException("El id no existe");
        }
        return ventaRepository.findById(id).orElse(null);
    }

    @Override
    public Ventas saveVentas(Ventas ventas) {
        return ventaRepository.save(ventas);
    }

    @Override
    public Ventas updateVentas(Integer id, Ventas ventas) {
        Ventas ventas1 = ventaRepository.findById(id).orElse(null);
        if (ventas1 != null) {
            ventas1.setFecha_venta(ventas.getFecha_venta());
            ventas1.setCantidad(ventas.getCantidad());
            ventas1.setTotal(ventas.getTotal());
            ventas1.setId_empleado(ventas.getId_empleado());
            ventas1.setId_repuesto(ventas.getId_repuesto());
        } else {
            throw new IllegalArgumentException("El id no existe");
        }
        return ventaRepository.save(ventas1);
    }

    @Override
    public void deleteVentas(Integer id) {
        Ventas ventas = ventaRepository.findById(id).orElse(null);
        if(ventas == null){
            throw new IllegalArgumentException("El id no existe");
        }
        ventaRepository.deleteById(id);
    }
}
