package com.constanzahurtado.estudiantes_cursos.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.constanzahurtado.estudiantes_cursos.models.Curso;
import com.constanzahurtado.estudiantes_cursos.models.Estudiante;
import com.constanzahurtado.estudiantes_cursos.services.ServicioCursos;
import com.constanzahurtado.estudiantes_cursos.services.ServicioEstudiantes;

import jakarta.validation.Valid;


@Controller
public class ControladorCursos {

    @Autowired
    private ServicioCursos servicioCursos;

    @Autowired
    private ServicioEstudiantes servicioEstudiantes;


    @GetMapping("/cursos")
    public String getEstudiantes(Model modelo) {
        modelo.addAttribute("cursos", this.servicioCursos.obtenerTodosLosCursos());
        return "cursos.jsp";
    }

    @GetMapping("/cursos/detalles/{id}")
    public String desplegarEstudiantesDelCurso(@PathVariable("id") Long id, Model modelo) {
        modelo.addAttribute("curso", this.servicioCursos.obtenerPorId(id));
        return "detalleCurso.jsp";
    }


    @GetMapping("/cursos/formulario/inscribir/{id}")
    public String formularioInscribirEstudiante(@PathVariable("id") Long id, Model modelo) {
        Curso curso = this.servicioCursos.obtenerPorId(id);
        modelo.addAttribute("curso", curso);
        List<Estudiante> estudiantes = this.servicioEstudiantes.obtenerTodosLosEstudiantes(); 
        List<Estudiante> noInscritos = new ArrayList<>();
        for(Estudiante e : estudiantes) {
            if(!curso.getEstudiantes().contains(e)) {
                noInscritos.add(e);
            }
        }
        modelo.addAttribute("noInscritos", noInscritos);
        return "inscribirEstudiantesEnCurso.jsp";
    }

    @PostMapping("/cursos/procesa/inscribir/{id}")
    public String procesarInscribirEstudiante(@RequestParam(value = "idEstudiantes", required = false) List<Long> idEstudiantes,
            @PathVariable("id") Long id,
            Model modelo) {
        Curso curso = this.servicioCursos.obtenerPorId(id);

        if(idEstudiantes != null) {
            for(Long idEstudiante : idEstudiantes){
                Estudiante newEstudiante = this.servicioEstudiantes.obtenerPorId(idEstudiante);
                curso.getEstudiantes().add(newEstudiante);
            }
            this.servicioCursos.actualizarCurso(curso);
        }
        return "redirect:/cursos/detalles/{id}";
    }

      /*
formularioCursoEstudiante(): Ruta a utilizar “/formulario/cursos/estudiantes/{idCurso}”. Desplegar la vista JSP agregarEstudianteCurso.jsp. Este formulario carga la lista de estudiantes en un <select>.
procesaAgregarEstudianteACurso(): Ruta a utilizar “/procesa/agregar/estudiante/curso/{idCurso}”. Redirige a la ruta de “/cursos”. Se encarga de agregar el estudiante al curso enviado como variable de ruta. */




    @GetMapping("/cursos/formulario/agregar")
    public String formularioAgregarCurso(Model modelo) {
        modelo.addAttribute("curso", new Curso());
        modelo.addAttribute("estudiantes", this.servicioEstudiantes.obtenerTodosLosEstudiantes());
        return "agregarCurso.jsp";
    }
    
    @PostMapping("/cursos/procesa/agregar")
    public String procesarAgregarCurso(@Valid @ModelAttribute("curso") Curso curso,
            BindingResult validaciones,
            @RequestParam(value = "idEstudiantes", required = false) List<Long> idEstudiantes,
            Model modelo) {

        if (validaciones.hasErrors()) {
            modelo.addAttribute("estudiantes", this.servicioEstudiantes.obtenerTodosLosEstudiantes());
            return "agregarCurso.jsp";
        }
        if(idEstudiantes != null) {
            for(Long idEstudiante : idEstudiantes){
                Estudiante newEstudiante = this.servicioEstudiantes.obtenerPorId(idEstudiante);
                curso.getEstudiantes().add(newEstudiante);
            }
        }
        this.servicioCursos.actualizarCurso(curso);
        return "redirect:/cursos";
    }






    
}
