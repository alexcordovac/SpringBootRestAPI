/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crudestudiantes.controladores;

import com.crudestudiantes.modelos.Calificacion;
import com.crudestudiantes.servicios.CalificacionServicio;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Alex
 */
@RestController
public class CalificacionControlador {
    
    @Autowired
    private CalificacionServicio servicio;
    
    @RequestMapping("/calificaciones")
    public List<Calificacion> listarTodo(){
        return servicio.listarTodo();
    }
    
    @RequestMapping("/calificaciones/{id}")
    public ResponseEntity<Calificacion> obtener(@PathVariable Integer id){
        try{
            Calificacion p = servicio.obtener(id);
            return new ResponseEntity<Calificacion>(p, HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<Calificacion>(HttpStatus.NOT_FOUND);        
        }
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/calificaciones")    
    public void agregar(@RequestBody Calificacion p){
        servicio.guardar(p);
    }
    
    @PutMapping("/calificaciones/{id}")
    public ResponseEntity<?> actualizar(@RequestBody Calificacion p, @PathVariable Integer id){
            Optional<Calificacion> cal = servicio.obtenerList(id);
            
            if(!cal.isPresent())
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            
            p.setIdCalificacion(id);
            servicio.guardar(p);
            return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @DeleteMapping("calificaciones/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id){
        try {
            servicio.eliminar(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
