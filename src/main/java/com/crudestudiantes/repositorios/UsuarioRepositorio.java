/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crudestudiantes.repositorios;

import com.crudestudiantes.modelos.UsuarioDao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Alex
 */
@Repository
public interface UsuarioRepositorio extends CrudRepository<UsuarioDao, Integer>{
    UsuarioDao findByNombreUsuario(String username);
}
