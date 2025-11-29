package com.constanzahurtado.estudiantes_cursos.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.constanzahurtado.estudiantes_cursos.models.Curso;
import com.constanzahurtado.estudiantes_cursos.models.Estudiante;
import com.constanzahurtado.estudiantes_cursos.services.ServicioCursos;
import com.constanzahurtado.estudiantes_cursos.services.ServicioEstudiantes;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class ControladorEstudiantes {

    @Autowired
    private ServicioEstudiantes servicioEstudiantes;
    
    @Autowired
    private ServicioCursos servicioCursos;


    @GetMapping("/estudiantes/detalles/{id}")
    public String desplegarCursosDeUnEstudiante(@PathVariable("id") Long id, Model modelo) {
        Estudiante estudiante = this.servicioEstudiantes.obtenerPorId(id);
        modelo.addAttribute("estudiante", estudiante);
        return "detalleEstudiante.jsp";
    }

    @GetMapping("/estudiantes")
    public String getEstudiantes(Model modelo) {
        modelo.addAttribute("estudiantes", this.servicioEstudiantes.obtenerTodosLosEstudiantes());
        return "estudiantes.jsp";
    }

    
    @GetMapping("/estudiantes/formulario/agregar")
    public String formularioAgregarEstudiante(Model modelo) {
        modelo.addAttribute("estudiante", new Estudiante());
        modelo.addAttribute("cursos", this.servicioCursos.obtenerTodosLosCursos());
        return "agregarEstudiante.jsp";
    }
    
    @PostMapping("/estudiantes/procesa/agregar")
    public String procesarAgregarEstudiante(@Valid @ModelAttribute("estudiante") Estudiante estudiante,
            BindingResult validaciones,
            @RequestParam(value = "idCursos", required = false) List<Long> idCursos,
            Model modelo) {

        if (validaciones.hasErrors()) {
            modelo.addAttribute("cursos", this.servicioCursos.obtenerTodosLosCursos());
            return "agregarEstudiante.jsp";
        }
        Estudiante newEstudiante = this.servicioEstudiantes.agregarEstudiante(estudiante);

        if(idCursos != null) {
            for(Long idCurso : idCursos){
                Curso newCurso = this.servicioCursos.obtenerPorId(idCurso);
                if(newCurso != null) {
                    newCurso.getEstudiantes().add(newEstudiante);
                    this.servicioCursos.actualizarCurso(newCurso);
                }
            }
        }
        return "redirect:/estudiantes";
    }


    
}
