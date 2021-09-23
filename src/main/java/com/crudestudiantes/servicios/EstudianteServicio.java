/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crudestudiantes.servicios;

import com.crudestudiantes.modelos.Estudiante;
import com.crudestudiantes.repositorios.EstudianteRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alex
 */

@Service
public class EstudianteServicio {
    
    @Autowired
     private EstudianteRepositorio repo;
    
    public List<Estudiante> listarTodo(){
        return repo.findAll();
    }
    
    public void guardar(Estudiante p){
        repo.save(p);
    } 
    
    public Estudiante obtener(Integer id){
        return repo.findById(id).get();
    }
    
    public Optional<Estudiante> obtenerList(Integer id){
        return repo.findById(id);
    }
    
    public void eliminar(Integer id){
        repo.deleteById(id);
    }
    
    public Estudiante buscarPorMatricula(String matricula){
        return repo.buscarPorMatricula(matricula);
    } 
}
