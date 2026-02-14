package com.jerrycastro.RepuestosAutomotriz.service;

import com.jerrycastro.RepuestosAutomotriz.entity.Ventas;
import com.jerrycastro.RepuestosAutomotriz.exception.ResourceNotFoundException;
import com.jerrycastro.RepuestosAutomotriz.repository.VentaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
        return ventaRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("El id de la venta no existe: " + id));
    }

    @Override
    public Ventas saveVentas(Ventas ventas) {
        if(ventas.getFecha_venta().isAfter(LocalDate.now())){
            throw new IllegalArgumentException("La fecha no puede ser futura");
        }

        if(ventas.getCantidad() <= 0){
            throw new IllegalArgumentException("La cantidad de venta no puede ser menor o igual a 0");
        }

        if(ventas.getTotal() <= 0){
            throw new IllegalArgumentException("El total de venta no puede ser menor o igual a 0");
        }

        return ventaRepository.save(ventas);
    }

    @Override
    public Ventas updateVentas(Integer id, Ventas ventas) {
        Ventas ventas1 = ventaRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("El id buscado no existe: " + id));

        ventas1.setFecha_venta(ventas.getFecha_venta());
        ventas1.setCantidad(ventas.getCantidad());
        ventas1.setTotal(ventas.getTotal());
        ventas1.setId_empleado(ventas.getId_empleado());
        ventas1.setId_repuesto(ventas.getId_repuesto());

        if(ventas1.getFecha_venta().isAfter(LocalDate.now())){
            throw new IllegalArgumentException("La fecha no puede ser futura");
        }

        if(ventas1.getCantidad() <= 0){
            throw new IllegalArgumentException("La cantidad de venta no puede ser menor o igual a 0");
        }

        if(ventas1.getTotal() <= 0){
            throw new IllegalArgumentException("El total de venta no puede ser menor o igual a 0");
        }

        return ventaRepository.save(ventas1);
    }

    @Override
    public void deleteVentas(Integer id) {
        Ventas ventas = ventaRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("El id buscado no existe: " + id));

        ventaRepository.deleteById(id);
    }
}
