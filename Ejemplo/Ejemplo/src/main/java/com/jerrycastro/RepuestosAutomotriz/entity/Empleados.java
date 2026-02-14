package com.jerrycastro.RepuestosAutomotriz.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

// Que es Entity: una entidad en spring boot es una clase anotada
// con entity que representa una tabla en una base de datos relacional
// actua como un puente entre la programación orientada a objetos y sql(JPA Hibernate)
// permitiendo mapear automaticamente atributos a columnas

@Entity
@Table(name = "Empleados")

public class Empleados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private Integer id_empleado;

    @NotBlank(message = "El campo no debe ir vacio")
    @Column(name = "nombre_empleado")
    private String nombre_empleado;

    @NotBlank(message = "El campo no debe ir vacio")
    @Column(name = "apellido_empleado")
    private String apellido_empleado;

    @NotBlank(message = "El campo no debe ir vacio")
    @Column(name = "puesto_empleado")
    private String puesto_empleado;

    @NotBlank(message = "El campo no debe ir vacio")
    @Column(name = "email_empleado")
    private String email_empleado;

    public Integer getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(Integer id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getNombre_empleado() {
        return nombre_empleado;
    }

    public void setNombre_empleado(String nombre_empleado) {
        this.nombre_empleado = nombre_empleado;
    }

    public String getApellido_empleado() {
        return apellido_empleado;
    }

    public void setApellido_empleado(String apellido_empleado) {
        this.apellido_empleado = apellido_empleado;
    }

    public String getPuesto_empleado() {
        return puesto_empleado;
    }

    public void setPuesto_empleado(String puesto_empleado) {
        this.puesto_empleado = puesto_empleado;
    }

    public String getEmail_empleado() {
        return email_empleado;
    }

    public void setEmail_empleado(String email_empleado) {
        this.email_empleado = email_empleado;
    }
}
