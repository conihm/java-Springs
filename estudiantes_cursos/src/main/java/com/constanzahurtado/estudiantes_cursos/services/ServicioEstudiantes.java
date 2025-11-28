package com.constanzahurtado.estudiantes_cursos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.constanzahurtado.estudiantes_cursos.models.Estudiante;
import com.constanzahurtado.estudiantes_cursos.repositories.RepositorioEstudiantes;

@Service
public class ServicioEstudiantes {

    @Autowired
    private RepositorioEstudiantes repositorioEstudiantes;

    public List<Estudiante> obtenerTodosLosEstudiantes() {
        return this.repositorioEstudiantes.findAll();
    }

    public Estudiante obtenerPorId(Long id) {
        return this.repositorioEstudiantes.findById(id).orElse(null);
    }

    public Estudiante agregarEstudiante(Estudiante estudiante) {
        return this.repositorioEstudiantes.save(estudiante);
    }

    public Estudiante actualizarEstudiante(Estudiante estudiante) {
        return this.repositorioEstudiantes.save(estudiante);
    }

    public void eliminarEstudiante(Long id){
        this.repositorioEstudiantes.deleteById(id);
    }

}
