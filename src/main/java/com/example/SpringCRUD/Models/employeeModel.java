package com.example.SpringCRUD.Models;

import javax.persistence.*;

/* Representacion de una tabla de la BD en una clase Java */
/* Esta anotación se debe de definir a nivel de clase y sirve para indicarle a JPA que esa clase es una Entity (modelo real) */
@Entity
/* Anotación para controlar manualmente el nombre de la tabla */
@Table(name = "empleados")

public class employeeModel {

    @Id /* Es un ID */
    @GeneratedValue(strategy = GenerationType.IDENTITY) /* Se genera automáticamente y se autoincrementa */
    @Column(unique = true, nullable = false) /* Es un valor único y no puede ser nulo */
    private Long id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String direccion;
    @Column(nullable = false)
    private String telefono;

    /* Si no se genera el constructor y sus parámetros no se mostrará ningún valor */
    public employeeModel() { }

    public employeeModel(Long id, String nombre, String direccion, String telefono) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}