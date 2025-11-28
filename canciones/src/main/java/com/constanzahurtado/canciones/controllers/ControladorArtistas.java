package com.constanzahurtado.canciones.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.constanzahurtado.canciones.models.Artista;
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

    @GetMapping("/artistas/formulario/agregar")
    public String formularioAgregarArtista(Model modelo) {
        modelo.addAttribute("artista", new Artista());
        return "agregarArtista.jsp";
    }

    @PostMapping("/artistas/procesa/agregar")
    public String procesarAgregarArtista(@Valid @ModelAttribute("artista") Artista artista,
                                        BindingResult validaciones) {
        if (validaciones.hasErrors()) {
            return "agregarArtista.jsp";
        }
        this.servicioArtistas.agregarArtista(artista);
        return "redirect:/artistas";
    }
}


