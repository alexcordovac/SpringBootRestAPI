package com.crudestudiantes.controladores;

import com.crudestudiantes.modelos.JwtRequest;
import com.crudestudiantes.modelos.JwtResponse;
import com.crudestudiantes.modelos.UsuarioDto;
import com.crudestudiantes.seguridad.JwtTokenUtil;
import com.crudestudiantes.servicios.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtAuthenticationController {

    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManagerBean;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;
    
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/autenticar", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        System.out.println(authenticationRequest);
        authenticate(authenticationRequest.getUsuario(), authenticationRequest.getContrasena());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsuario());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }
    
    @RequestMapping(value = "/registrar", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UsuarioDto user) throws Exception {
		return ResponseEntity.ok(userDetailsService.save(user));
	}

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManagerBean.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

}
