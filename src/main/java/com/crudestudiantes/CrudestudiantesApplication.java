package com.crudestudiantes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@ComponentScan({"com.crudestudiantes.controladores", "com.crudestudiantes.repositorios", "com.crudestudiantes.servicios", "com.crudestudiantes.seguridad"})
//@EnableJpaRepositories("com.crudestudiantes.repositorios")
@SpringBootApplication
public class CrudestudiantesApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudestudiantesApplication.class, args);
    }
}
