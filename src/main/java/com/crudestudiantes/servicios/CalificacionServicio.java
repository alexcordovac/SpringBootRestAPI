/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crudestudiantes.servicios;

import com.crudestudiantes.modelos.Calificacion;
import com.crudestudiantes.repositorios.CalificacionRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alex
 */
@Service
public class CalificacionServicio {
    
    @Autowired
    private CalificacionRepositorio repo;
    
    public List<Calificacion> listarTodo(){
        return repo.findAll();
    }
    
    public void guardar(Calificacion p){
        repo.save(p);
    } 
    
    public Calificacion obtener(Integer id){
        return repo.findById(id).get();
    }
    
    public Optional<Calificacion> obtenerList(Integer id){
        return repo.findById(id);
    }
    
    public void eliminar(Integer id){
        repo.deleteById(id);
    }
}
