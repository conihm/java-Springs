package com.constanzahurtado.peliculas_y_directores.Controllers;

import java.util.HashMap;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class ControladorPeliculas {
    
    private static HashMap<String, String> listaPeliculas = new HashMap<String, String>();

    public ControladorPeliculas() {
        listaPeliculas.put("Winnie the Pooh", "Don Hall");	
        listaPeliculas.put("El zorro y el sabueso", "Ted Berman");
        listaPeliculas.put("Tarzán", "Kevin Lima");		
        listaPeliculas.put("Mulán", "Barry Cook");
        listaPeliculas.put("Oliver", "Kevin Lima");	
        listaPeliculas.put("Big Hero 6", "Don Hall");	
    }

    @GetMapping("/peliculas")
    public String obtenerTodasLasPeliculas() {
        String peliculas = "";
        for(String pelicula : listaPeliculas.keySet()) {
            String director = listaPeliculas.get(pelicula);
            peliculas += pelicula + " - " + director + "<br>";
        }
        return peliculas;
    }

    @GetMapping("/peliculas/{nombre}")
    public String obtenerPeliculaPorNombre(@PathVariable String nombre) {
        if(listaPeliculas.containsKey(nombre)) {
            String director = listaPeliculas.get(nombre);
            return "Película: " + nombre + " || Director: " + director;
        }
        return "La película no se encuentra en nuestra lista.";
    }

    @GetMapping("/peliculas/director/{nombre}")
    public String obtenerPeliculasPorDirector(@PathVariable String nombre) {
        String peliculas = "";
        boolean found = false;
        for(String pelicula : listaPeliculas.keySet()) {
            String director = listaPeliculas.get(pelicula);
            if(director.equalsIgnoreCase(nombre)) {
                found = true;
                peliculas += pelicula + "<br>";
            }  
        }
        if(!found)
            return "No contamos con películas con ese director en nuestra lista.";
        return "Películas de " + nombre + ": <br>" + peliculas;
    }


}
