package com.constanzahurtado.estudiantes_cursos.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.constanzahurtado.estudiantes_cursos.services.ServicioEstudiantes;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class ControladorEstudiantes {

    @Autowired
    private ServicioEstudiantes servicioEstudiantes;

    @GetMapping("/estudiantes")
    public String getEstudiantes(Model modelo) {
        modelo.addAttribute("estudiantes", this.servicioEstudiantes.obtenerTodosLosEstudiantes());
        return "estudiantes.jsp";
    }
    
    
    @PostMapping("/estudiantes/formulario/agregar”")
    public String formularioAgregarEstudiante() {
        
        return "";
    }



    
}
