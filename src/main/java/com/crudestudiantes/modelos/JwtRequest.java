package com.crudestudiantes.modelos;

import java.io.Serializable;

public class JwtRequest implements Serializable {

    private static final long serialVersionUID = 5926468583005150707L;

    private String usuario;
    private String contrasena;

    //need default constructor for JSON Parsing
    public JwtRequest() {

    }

    public JwtRequest(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }
    
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "JwtRequest{" + "usuario=" + usuario + ", contrasena=" + contrasena + '}';
    }
    
    

}
