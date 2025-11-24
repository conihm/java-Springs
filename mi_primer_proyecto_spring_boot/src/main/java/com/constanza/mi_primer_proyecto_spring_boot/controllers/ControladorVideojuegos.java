package com.constanza.mi_primer_proyecto_spring_boot.controllers;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import com.constanza.mi_primer_proyecto_spring_boot.interfaces.ManejoDeFechas;
import com.constanza.mi_primer_proyecto_spring_boot.models.Videojuego;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
//Requestmapping par agregar subrutas
//@RequestMapping("/mensajes")
public class ControladorVideojuegos implements ManejoDeFechas {
    
    	
	private ArrayList<Videojuego> videojuegos;

	public ControladorVideojuegos() {
        this.videojuegos = new ArrayList<>();
        Videojuego v1 = new Videojuego(1l, "Silent Hill 2",
                "Having received a letter from his deceased wife, James heads to where they shared so many memories, in the hope of seeing her one more time: Silent Hill.",
                "https://shared.fastly.steamstatic.com/store_item_assets/steam/apps/2124490/capsule_616x353.jpg?t=1744248682",
                formatearFecha("08/10/2024"), 4.8);
        Videojuego v2 = new Videojuego(2l, "Outlast",
                "Outlast follows the story of investigative journalist Miles Upshur, that got the lead on the inhuman experiments, performed on the asylum patients.",
                "https://shared.akamai.steamstatic.com/store_item_assets/steam/apps/238320/capsule_616x353.jpg?t=1666817106",
                formatearFecha("03/09/2013"), 4.5);
        Videojuego v3 = new Videojuego(3l, "Resident Evil 2",
                "The story follows the survivors of a zombie virus outbreak in the fictional Raccoon City.",
                "https://shared.akamai.steamstatic.com/store_item_assets/steam/apps/883710/header.jpg?t=1728438541",
                formatearFecha("25/01/2019"), 4.3);
        this.videojuegos.add(v1);
        this.videojuegos.add(v2);
        this.videojuegos.add(v3);
    }

	@GetMapping("/getAll")
	public String getVideojuegos(Model modelo) {
		 modelo.addAttribute("videojuegos", this.videojuegos);
		 return "videojuegos.jsp";
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

	@GetMapping("pruebas")
	public String pruebas() {
		return "pruebas.jsp";
	}

	@GetMapping("/form/add")
	public String formAgregar() {
		return "agregar.jsp";
	}

	@PostMapping("/add")
	public String guardar(	@RequestParam String nombre,
							@RequestParam String descripcion,
							@RequestParam String portada,
							@RequestParam String fechaLanzamiento,
							@RequestParam String rating) {
		
		long nuevoId = videojuegos.size() + 1;
		Videojuego juego = new Videojuego(	nuevoId, 
											nombre, 
											descripcion, 
											portada, 
											formatearFecha(fechaLanzamiento), 
											Double.parseDouble(rating));
		videojuegos.add(juego);
		return "redirect:/getAll";
	}


	
	@RequestMapping(value="/saludo", method=RequestMethod.GET)
	public String inicio() {
		return "Hola hola Spring boot!!!!";
	}
        
}
