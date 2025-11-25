package com.constanzahurtado.explorador_de_recetas.controllers;

import java.util.Arrays;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ControladorRecetas {
    
    private static String[] listaRecetas = {"Pizza", "Espagueti", "Lasaña"};
    private static HashMap<String, String []> recetasConIngredientes = new HashMap<String, String[]>();

    public ControladorRecetas() {
        String [] pizza = {"Pan", "Salsa de tomate", "Queso", "Pepperoni"};
        recetasConIngredientes.put("Pizza", pizza);
        String [] espagueti = {"Pasta", "Salsa de tomate", "Carne molida", "Queso parmesano"};
        recetasConIngredientes.put("Espagueti", espagueti);
        String [] lasaña = {"Pasta", "Salsa de tomate", "Queso", "Albahaca", "Espinaca", "Champiñones"};
        recetasConIngredientes.put("Lasaña", lasaña);
    }

    @GetMapping("/recetas")
    public String obtenerTodasLasRecetas(Model modelo) {
        modelo.addAttribute("listaRecetas", listaRecetas);
        return "recetas.jsp";
    }

    @GetMapping("/recetas/{nombre}")
    public String obtenerRecetaPorNombre(@PathVariable String nombre, Model modelo) {
        if(recetasConIngredientes.containsKey(nombre)) {
			modelo.addAttribute("nombreReceta", nombre);
            String ingredientes = Arrays.toString(recetasConIngredientes.get(nombre));
            modelo.addAttribute("ingredientes", ingredientes);
		} else {
			modelo.addAttribute("mensaje", "La receta no se encuentra en nuestra lista.");
		}
		
		return "detalleReceta.jsp";
    }


    /*
    public String obtenerInformacionDeLibro(@PathVariable String nombre, Model modelo) {
		if(listaLibros.containsKey(nombre)) {
			modelo.addAttribute("nombreLibro", nombre);
			modelo.addAttribute("nombreAutor", listaLibros.get(nombre));
		} else {
			modelo.addAttribute("mensaje", "El libro no se encuentra en nuestra lista.");
		}
		
		return "detalleLibro.jsp";
	}
	
	@GetMapping("/libro/formulario")
	public String formularioLibro() {
		return "formularioLibros.jsp";
	}
	
	@PostMapping("/procesa/libros")
	public String procesaLibro(@RequestParam String nombreLibro,
							   @RequestParam String nombreAutor) {
		listaLibros.put(nombreLibro, nombreAutor);
		return "redirect:/libros";
	}
	 */
    

    


}
