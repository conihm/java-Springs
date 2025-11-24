package com.constanza.mi_primer_proyecto_spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@SpringBootApplication
@RestController
public class MiPrimerProyectoSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiPrimerProyectoSpringBootApplication.class, args);
	}

		
		
}
