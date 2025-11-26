package com.constanzahurtado.canciones.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import com.constanzahurtado.canciones.models.Cancion;
import com.constanzahurtado.canciones.services.ServicioCanciones;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;



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
        if(cancion == null)
            return "redirect:/canciones";
        modelo.addAttribute("cancion", cancion);
        return "detalleCancion.jsp";
    }

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

    @GetMapping("/canciones/formulario/editar/{id}")
    public String formularioEditarCancion(Model model, @PathVariable("id") Long id) {
        model.addAttribute("cancion", this.servicioCanciones.obtenerCancionPorId(id));
        return "editarCancion.jsp";
    }

    @PutMapping("/canciones/procesa/editar/{id}")
    public String procesarEditarCancion(@Valid @ModelAttribute("cancion") Cancion cancion,
            BindingResult validaciones) {

        if (validaciones.hasErrors()) {
            return "editarCancion.jsp";
        }
        this.servicioCanciones.actualizarCancion(cancion);
        return "redirect:/canciones";
    }
    
}
