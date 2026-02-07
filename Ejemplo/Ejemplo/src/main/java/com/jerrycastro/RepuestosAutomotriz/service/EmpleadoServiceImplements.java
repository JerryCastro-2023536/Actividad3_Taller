package com.jerrycastro.RepuestosAutomotriz.service;

import com.jerrycastro.RepuestosAutomotriz.model.Empleados;
import com.jerrycastro.RepuestosAutomotriz.repository.EmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImplements implements EmpleadosService{
    private final EmpleadoRepository empleadoRepository;

    public EmpleadoServiceImplements(EmpleadoRepository empleadoRepository){
        this.empleadoRepository = empleadoRepository;
    }

    @Override
    public List<Empleados> getAllEmpleados() {
        return empleadoRepository.findAll();
    }

    @Override
    public Empleados getEmpleadoById(Integer id) {
        return empleadoRepository.findById(id).orElse(null);
    }

    @Override
    public Empleados saveEmpleado(Empleados empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public Empleados updateEmpleado(Integer id, Empleados empleado) throws RuntimeException {
        return null;
    }

    @Override
    public void deleteEmpleado(Integer id) {
        empleadoRepository.deleteById(id);
    }

}
