/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crudestudiantes.servicios;

import com.crudestudiantes.modelos.UsuarioDao;
import com.crudestudiantes.modelos.UsuarioDto;
import com.crudestudiantes.repositorios.UsuarioRepositorio;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alex
 */
@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioDao user = usuarioRepositorio.findByNombreUsuario(username);
        
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(user.getNombreUsuario(), user.getContrasena(), new ArrayList<>());
    }

    public UsuarioDao save(UsuarioDto user) {
        UsuarioDao newUser = new UsuarioDao();
        newUser.setNombreUsuario(user.getNombreUsuario());
        newUser.setContrasena(bcryptEncoder.encode(user.getContrasena()));
        
        //fecha
        Timestamp fecha = new Timestamp(new Date().getTime());
        newUser.setFechaCreacion(fecha);
        
        //guardamos
        return usuarioRepositorio.save(newUser);
    }
}
