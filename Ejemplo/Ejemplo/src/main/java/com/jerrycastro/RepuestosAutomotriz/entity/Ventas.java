package com.jerrycastro.RepuestosAutomotriz.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Ventas")
public class Ventas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta")
    private Integer id_venta;

    @NotNull(message = "El campo no debe ir vacio")
    @Column(name = "fecha_venta")
    private LocalDate fecha_venta;

    @NotNull(message = "El campo no debe ir vacio")
    @Column(name = "cantidad")
    private Integer cantidad;

    @NotNull(message = "El campo no debe ir vacio")
    @Column (name = "total")
    private Double total;

    @NotNull(message = "El campo no debe ir vacio")
    @Column(name = "id_empleado")
    private Integer id_empleado;

    @NotNull(message = "El campo no debe ir vacio")
    @Column(name = "id_repuesto")
    private Integer id_repuesto;

    public Integer getId_venta() {
        return id_venta;
    }

    public void setId_venta(Integer id_venta) {
        this.id_venta = id_venta;
    }

    public LocalDate getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(LocalDate fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(Integer id_empleado) {
        this.id_empleado = id_empleado;
    }

    public Integer getId_repuesto() {
        return id_repuesto;
    }

    public void setId_repuesto(Integer id_repuesto) {
        this.id_repuesto = id_repuesto;
    }
}
