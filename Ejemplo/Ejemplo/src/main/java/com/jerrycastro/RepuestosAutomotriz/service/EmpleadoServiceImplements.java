package com.jerrycastro.RepuestosAutomotriz.service;

import com.jerrycastro.RepuestosAutomotriz.entity.Empleados;
import com.jerrycastro.RepuestosAutomotriz.exception.ExistsEmailException;
import com.jerrycastro.RepuestosAutomotriz.exception.InvalidEmailException;
import com.jerrycastro.RepuestosAutomotriz.exception.ResourceNotFoundException;
import com.jerrycastro.RepuestosAutomotriz.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImplements implements EmpleadosService{
    @Autowired
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

        String nombreEmpleado = empleado.getNombre_empleado() + empleado.getApellido_empleado();
        String correo = empleado.getEmail_empleado();
        List<Empleados> empleados1 = empleadoRepository.findAll();

        for(Empleados e : empleados1){
            if(nombreEmpleado.equals(e.getNombre_empleado() + e.getApellido_empleado())){
                throw new IllegalArgumentException("El nombre completo del empleado ya existe");
            }
        }

        for(Empleados e : empleados1){
            if(correo.equals(e.getEmail_empleado())){
                throw  new ExistsEmailException("El correo ya ha sido registrado");
            }
        }

        if(!(empleado.getEmail_empleado().contains("@gmail.com")||
                empleado.getEmail_empleado().contains("@yahoo.com")
                || empleado.getEmail_empleado().contains("@outlook.com"))){
            throw new InvalidEmailException("El correo tiene un formato invalido");
        }
        return empleadoRepository.save(empleado);
    }

    @Override
    public Empleados getEmpleadoById(Integer id) {
        return empleadoRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("El id buscado no existe: " + id));
    }

    @Override
    public Empleados updateEmpleado(Integer id, Empleados empleado) throws RuntimeException {
        Empleados empleado1 = empleadoRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("El id buscado no existe: " + id));

        empleado1.setNombre_empleado(empleado.getNombre_empleado());
        empleado1.setApellido_empleado(empleado.getApellido_empleado());
        empleado1.setPuesto_empleado(empleado.getPuesto_empleado());
        empleado1.setEmail_empleado(empleado.getEmail_empleado());

        String nombreEmpleado = empleado1.getNombre_empleado() + empleado1.getApellido_empleado();
        List<Empleados> empleados2 = empleadoRepository.findAll();

        for(Empleados e : empleados2){
            if(nombreEmpleado.equals(e.getNombre_empleado() + e.getApellido_empleado())){
                throw new IllegalArgumentException("El nombre completo del empleado ya existe");
            }
        }

        for(Empleados e : empleados2){
            if(empleado1.getEmail_empleado().equals(e.getEmail_empleado())){
                throw  new ExistsEmailException("El correo ya ha sido registrado");
            }
        }

        if(!(empleado1.getEmail_empleado().contains("@gmail.com")||
                empleado.getEmail_empleado().contains("@yahoo.com")
                || empleado.getEmail_empleado().contains("@outlook.com"))){
            throw new InvalidEmailException("El correo actualizado tiene un formato invalido");
        }
        return empleadoRepository.save(empleado1);
    }

    @Override
    public void deleteEmpleado(Integer id) {
        Empleados empleados = empleadoRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("El id buscado no existe: " + id));

        empleadoRepository.deleteById(id);
    }

}
