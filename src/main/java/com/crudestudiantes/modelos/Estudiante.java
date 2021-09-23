/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crudestudiantes.modelos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Alex
 */

@Entity(name = "estudiantes")
@Table(name = "estudiantes")
public class Estudiante {
    
    @Id
    @Column(name = "idEstudiante")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEstudiante;
    
    @Column(name = "matricula", nullable = false, length=50)
    private String matricula;
    
    @Column(name = "nombre", nullable = false, length=50)
    private String nombre;
    
    @Column(name = "apellidos", nullable = false, length=100)
    private String apellidos;
    
    @Column(name = "edad", nullable = false, columnDefinition = "TINYINT(4)")
    private String edad;
    
    @Column(name = "carrera", nullable = false, length=50)
    private String carrera;
    
    @Column(name = "cicloActual", nullable = false, columnDefinition = "TINYINT(4)")
    private String cicloActual;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(foreignKey = @ForeignKey(name = "estudiantes_ibfk_1"), name = "idCalificacion", referencedColumnName = "idCalificacion")
    private Calificacion idCalificacion;

    public Estudiante() {
    }

    public Estudiante(Integer idEstudiante, String nombre, String apellidos, String edad, String carrera, String cicloActual, Calificacion idCalificacion) {
        this.idEstudiante = idEstudiante;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.carrera = carrera;
        this.cicloActual = cicloActual;
        this.idCalificacion = idCalificacion;
    }

    public Integer getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getCicloActual() {
        return cicloActual;
    }

    public void setCicloActual(String cicloActual) {
        this.cicloActual = cicloActual;
    }

    public Calificacion getIdCalificacion() {
        return idCalificacion;
    }

    public void setIdCalificacion(Calificacion idCalificacion) {
        this.idCalificacion = idCalificacion;
    }
    
}
