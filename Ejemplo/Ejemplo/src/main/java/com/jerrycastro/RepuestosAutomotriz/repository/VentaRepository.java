package com.jerrycastro.RepuestosAutomotriz.repository;

import com.jerrycastro.RepuestosAutomotriz.entity.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository<Ventas, Integer> {
}
