/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crudestudiantes.repositorios;

import com.crudestudiantes.modelos.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Alex
 */
@Repository
public interface EstudianteRepositorio extends JpaRepository<Estudiante, Integer> {
    
    @Query("SELECT e FROM estudiantes e WHERE e.matricula = :matriculaP")
    Estudiante buscarPorMatricula(String matriculaP);
}
    