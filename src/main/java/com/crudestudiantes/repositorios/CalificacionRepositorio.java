/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crudestudiantes.repositorios;

import com.crudestudiantes.modelos.Calificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Alex
 */
@Repository
public interface CalificacionRepositorio extends JpaRepository<Calificacion, Integer>{
    
}
