package com.jerrycastro.RepuestosAutomotriz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jerrycastro.RepuestosAutomotriz.entity.Repuestos;

public interface RepuestosRepository extends JpaRepository<Repuestos, Integer> {
}
