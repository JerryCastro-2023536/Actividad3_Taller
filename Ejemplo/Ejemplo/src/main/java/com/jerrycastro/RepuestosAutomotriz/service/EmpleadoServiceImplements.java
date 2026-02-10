package com.jerrycastro.RepuestosAutomotriz.service;

import com.jerrycastro.RepuestosAutomotriz.entity.Empleados;
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
    public Empleados saveEmpleado(Empleados empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public Empleados getEmpleadoById(Integer id) {
        Empleados empleados = empleadoRepository.findById(id).orElse(null);
        if (empleados == null) {
            throw new IllegalArgumentException("El id no existe");
        }
        return empleadoRepository.findById(id).orElse(null);
    }

    @Override
    public Empleados updateEmpleado(Integer id, Empleados empleado) throws RuntimeException {
        Empleados empleado1 = empleadoRepository.findById(id).orElse(null);
        if(empleado1 != null){
            empleado1.setNombre_empleado(empleado.getNombre_empleado());
            empleado1.setApellido_empleado(empleado.getApellido_empleado());
            empleado1.setPuesto_empleado(empleado.getPuesto_empleado());
            empleado1.setEmail_empleado(empleado.getEmail_empleado());
        }else{
            throw new IllegalArgumentException ("El id no existe");
        }

        return empleadoRepository.save(empleado1);
    }

    @Override
    public void deleteEmpleado(Integer id) {
        Empleados empleados = empleadoRepository.findById(id).orElse(null);
        if(empleados == null){
            throw new IllegalArgumentException("No existe el id");
        }
        empleadoRepository.deleteById(id);
    }

}
