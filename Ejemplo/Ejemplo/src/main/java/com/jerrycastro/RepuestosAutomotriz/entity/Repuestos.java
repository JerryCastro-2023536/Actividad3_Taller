package com.jerrycastro.RepuestosAutomotriz.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Repuestos")
public class Repuestos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_repuesto")
    private Integer id_repuesto;

    @Column(name = "nombre_repuesto")
    private String nombre_repuesto;

    @Column(name = "categoria_repuesto")
    private String categoria_repuesto;

    @Column(name = "precio_compra")
    private Double precio_compra;

    @Column(name = "precio_venta")
    private Double precio_venta;

    @Column(name = "id_proveedor")
    private Integer id_proveedor;

    public Integer getId_repuesto() {
        return id_repuesto;
    }

    public void setId_repuesto(Integer id_repuesto) {
        this.id_repuesto = id_repuesto;
    }

    public String getNombre_repuesto() {
        return nombre_repuesto;
    }

    public void setNombre_repuesto(String nombre_repuesto) {
        this.nombre_repuesto = nombre_repuesto;
    }

    public String getCategoria_repuesto() {
        return categoria_repuesto;
    }

    public void setCategoria_repuesto(String categoria_repuesto) {
        this.categoria_repuesto = categoria_repuesto;
    }

    public Double getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(Double precio_compra) {
        this.precio_compra = precio_compra;
    }

    public Double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(Double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public Integer getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(Integer id_proveedor) {
        this.id_proveedor = id_proveedor;
    }
}
