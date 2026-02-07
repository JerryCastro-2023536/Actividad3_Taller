package com.jerrycastro.RepuestosAutomotriz.repository;

import com.jerrycastro.RepuestosAutomotriz.model.Empleados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleados, Integer> {
}
