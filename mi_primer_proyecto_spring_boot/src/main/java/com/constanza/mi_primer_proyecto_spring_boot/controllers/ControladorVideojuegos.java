package com.constanza.mi_primer_proyecto_spring_boot.controllers;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.constanza.mi_primer_proyecto_spring_boot.interfaces.ManejoDeFechas;
import com.constanza.mi_primer_proyecto_spring_boot.models.Videojuego;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
//Requestmapping par agregar subrutas
//@RequestMapping("/mensajes")
public class ControladorVideojuegos implements ManejoDeFechas {
    
    	
	private ArrayList<Videojuego> videojuegos;

	public ControladorVideojuegos() {
		videojuegos = new ArrayList<>();

		Videojuego v1 = new Videojuego("Silent Hill 2",
				"Having received a letter from his deceased wife, James heads to where they shared so many memories, in the hope of seeing her one more time: Silent Hill.",
				"", formatearFecha("2024-10-08"), 4.8, new ArrayList(Arrays.asList("Adventure", "Action")),
				new ArrayList(Arrays.asList("PC", "PlayStation")));
	
		Videojuego v2 = new Videojuego("Outlast",
				"Outlast follows the story of investigative journalist Miles Upshur, that got the lead on the inhuman experiments, performed on the asylum patients.",
				"", formatearFecha("2013-09-03"), 4.5, new ArrayList(Arrays.asList("Indie", "Action")),
				new ArrayList(Arrays.asList("PC", "PlayStation", "Xbox", "Nintendo")));

		Videojuego v3 = new Videojuego("Resident Evil",
                "The story follows the survivors of a zombie virus outbreak in the fictional Raccoon City.", "",
                formatearFecha("2019-01-25"), 4.3, new ArrayList(Arrays.asList("Shooter", "Action", "Adventure")),
                new ArrayList(Arrays.asList("PC", "PlayStation", "Xbox", "Nintendo")));
	
		videojuegos.add(v1);
		videojuegos.add(v2);
		videojuegos.add(v3);

	}

	@GetMapping("/getAll")
	public String getVideojuegos() {
		String lista = "";
		for(Videojuego v : videojuegos) {
			lista += v.toString() +"\n***\n";
		}
		return lista;
	}
	

	@GetMapping("/get/nombre")
	public String getVideojuegoPorNombre(@RequestParam("nombre") String nombre) {
		return buscar(nombre).toString();
	}

	private Videojuego buscar(String nombre) {
		for(Videojuego v : videojuegos) {
			if(v.getNombre().equalsIgnoreCase(nombre))
				return v;
		}
		return null;
	}

	@GetMapping("/get/nombre/{nombre}")
	public String getVideojuegoPorNombreV2(@PathVariable("nombre") String nombre) {
		return buscar(nombre).toString();
	}
	






	
	@RequestMapping(value="/saludo", method=RequestMethod.GET)
	public String inicio() {
		return "HOla hola Spring boot!!!!";
	}
        
}
