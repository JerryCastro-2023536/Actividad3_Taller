package com.jerrycastro.RepuestosAutomotriz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jerrycastro.RepuestosAutomotriz.entity.Proveedores;

public interface ProveedorRepository extends JpaRepository<Proveedores, Integer> {
}
