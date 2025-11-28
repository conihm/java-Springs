package com.constanzahurtado.canciones.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.constanzahurtado.canciones.models.Cancion;
import com.constanzahurtado.canciones.services.ServicioArtistas;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class ControladorArtistas {

    @Autowired    
    private ServicioArtistas servicioArtistas;

    @GetMapping("/artistas")
    public String desplegarArtistas(Model modelo) {
        modelo.addAttribute("artistas", this.servicioArtistas.obtenerTodosLosArtistas());
        return "artistas.jsp";
    }

    @GetMapping("/artistas/detalles/{id}")
    public String desplegarDetalleArtista(@PathVariable("id") Long id, Model modelo) {
        modelo.addAttribute("artista", this.servicioArtistas.obtenerArtistaPorId(id));
        return "detalleArtista.jsp";
    }

        /*
formularioAgregarArtista): Ruta a utilizar “/artistas/formulario/agregar/{idArtista}”. 
Desplegar la vista JSP agregarArtista.jsp. Este formulario cuenta con todos los campos/atributos de un artista.
procesarAgregarArtista(): Ruta a utilizar “/artistas/procesa/agregar”. 
Agrega el artista a la base de datos. Redirige a la ruta de “/artistas”. 
En caso de que el formulario no pase alguna validación hay que redirigir 
al mismo formulario agregarArtista.jsp para mostrar los errores. 

     @GetMapping("/canciones/formulario/agregar")
    public String formularioAgregarCancion(Model modelo) {
        modelo.addAttribute("cancion", new Cancion());
        return "agregarCancion.jsp";
    }

    @PostMapping("/canciones/procesa/agregar")
    public String procesarAgregarCancion(@Valid @ModelAttribute("cancion") Cancion cancion,
            BindingResult validaciones) {

        if (validaciones.hasErrors()) {
            return "agregarCancion.jsp";
        }
        this.servicioCanciones.agregarCancion(cancion);
        return "redirect:/canciones";
    }
        */



  
}


