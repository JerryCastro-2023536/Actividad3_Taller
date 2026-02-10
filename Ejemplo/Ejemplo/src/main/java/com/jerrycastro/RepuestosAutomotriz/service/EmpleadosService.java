package com.jerrycastro.RepuestosAutomotriz.service;

import com.jerrycastro.RepuestosAutomotriz.entity.Empleados;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmpleadosService {
    List<Empleados> getAllEmpleados();
    Empleados getEmpleadoById(Integer id);
    Empleados saveEmpleado(Empleados empleado) throws RuntimeException ;
    Empleados updateEmpleado(Integer id, Empleados empleado);
    void deleteEmpleado(Integer id);

}
