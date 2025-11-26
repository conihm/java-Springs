package com.constanzahurtado.canciones.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.constanzahurtado.canciones.models.Cancion;
import com.constanzahurtado.canciones.services.ServicioCanciones;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class ControladorCanciones {

    @Autowired
    private ServicioCanciones servicioCanciones;

    @GetMapping("/canciones")
    public String desplegarCanciones(Model modelo) {
        modelo.addAttribute("canciones", this.servicioCanciones.obtenerTodasLasCanciones());
        return "canciones.jsp";
    }

    @GetMapping("/canciones/detalles/{id}")
    public String desplegarDetalleCancion(@PathVariable Long id, Model modelo) {
        Cancion cancion = this.servicioCanciones.obtenerCancionPorId(id);
        modelo.addAttribute("cancion", cancion);
        return "detalleCancion.jsp";
    }

    
    
}
