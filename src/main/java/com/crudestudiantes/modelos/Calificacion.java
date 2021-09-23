/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crudestudiantes.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Alex
 */

@Entity
@Table(name = "calificacion")
public class Calificacion {
    
    @Id
    @Column(name = "idCalificacion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCalificacion;
    
    @Column(name = "parcial1", columnDefinition = "FLOAT", nullable = true)
    private Float parcial1;
    
    @Column(name = "parcial2", columnDefinition = "FLOAT", nullable = true)
    private Float parcial2;
    
    @Column(name = "parcial3", columnDefinition = "FLOAT", nullable = true)
    private Float parcial3;
    
    public Calificacion(){
    }
    
    public Calificacion(Integer idCalificacion, Float parcial1, Float parcial2, Float parcial3) {
        this.idCalificacion = idCalificacion;
        this.parcial1 = parcial1;
        this.parcial2 = parcial2;
        this.parcial3 = parcial3;
    }
    public Calificacion(Float parcial1, Float parcial2, Float parcial3) {
        this.parcial1 = parcial1;
        this.parcial2 = parcial2;
        this.parcial3 = parcial3;
    }

    public Integer getIdCalificacion() {
        return idCalificacion;
    }

    public void setIdCalificacion(Integer idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    public Float getParcial1() {
        return parcial1;
    }

    public void setParcial1(Float parcial1) {
        this.parcial1 = parcial1;
    }

    public Float getParcial2() {
        return parcial2;
    }

    public void setParcial2(Float parcial2) {
        this.parcial2 = parcial2;
    }

    public Float getParcial3() {
        return parcial3;
    }

    public void setParcial3(Float parcial3) {
        this.parcial3 = parcial3;
    }
    
    
    
}

