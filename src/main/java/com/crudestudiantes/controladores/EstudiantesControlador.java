/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crudestudiantes.controladores;

import com.crudestudiantes.modelos.Estudiante;
import com.crudestudiantes.servicios.EstudianteServicio;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
public class EstudiantesControlador {
    
    @Autowired
    private EstudianteServicio servicio;
    
    @GetMapping("/estudiantes")
    public List<Estudiante> listarTodo(){
        return servicio.listarTodo();
    }
    
    @GetMapping("/estudiantes/{id}")
    public ResponseEntity<Estudiante> obtener(@PathVariable Integer id){
        try{
            Estudiante p = servicio.obtener(id);
            return new ResponseEntity<>(p, HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);        
        }
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/estudiantes")    
    public void agregar(@RequestBody Estudiante p){
        servicio.guardar(p);
    }
    
    @PutMapping("/estudiantes/{id}")
    public ResponseEntity<?> actualizar(@RequestBody Estudiante p, @PathVariable Integer id){
        Optional<Estudiante> es = servicio.obtenerList(id);
        
        if(!es.isPresent())
            return new ResponseEntity<>("No se ha encontrado el id especificado",
                    HttpStatus.NOT_FOUND);
        
        p.setIdEstudiante(id);
        servicio.guardar(p);
        return new ResponseEntity<>("Actualizado correctamente",HttpStatus.OK);
    }
    
    @DeleteMapping("/estudiantes/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id){
        try {
            servicio.eliminar(id);
            return new ResponseEntity<>("Eliminado correctamente",HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Error al eliminar", HttpStatus.BAD_REQUEST);
        }
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/estudiantes/matricula/{x}")
    public ResponseEntity<Estudiante> buscarPorMatricula(@PathVariable("x") String matricula){
        try{
            Estudiante es = servicio.buscarPorMatricula(matricula);
            return new ResponseEntity<>(es, HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);        
        }
    }
}
