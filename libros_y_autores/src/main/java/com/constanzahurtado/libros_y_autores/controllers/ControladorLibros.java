package com.constanzahurtado.libros_y_autores.controllers;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ControladorLibros {
    
    private static HashMap<String, String> listaLibros = new HashMap<String, String>();

    public ControladorLibros() {
        listaLibros.put("Odisea", "Homero");	
        listaLibros.put("Don Quijote de la Mancha", "Miguel de Cervantes");
        listaLibros.put("El Código Da Vinci", "Dan Brown");		
        listaLibros.put("Alicia en el país de las maravillas", "Lewis Carroll");
        listaLibros.put("El Hobbit", "J.R.R. Tolkien");	
        listaLibros.put("El alquimista", "Paulo Coelho");	
    }

    @GetMapping("/libros")
    public String obtenerTodosLosLibros(Model modelo) {
        modelo.addAttribute("listaLibros", listaLibros);
        return "libros.jsp";
    }
    

}
