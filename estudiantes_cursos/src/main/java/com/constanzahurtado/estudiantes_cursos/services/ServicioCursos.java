package com.constanzahurtado.estudiantes_cursos.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.constanzahurtado.estudiantes_cursos.models.Curso;
import com.constanzahurtado.estudiantes_cursos.repositories.RepositorioCursos;

@Service
public class ServicioCursos {


    @Autowired
    private RepositorioCursos repositorioCursos;

    public List<Curso> obtenerTodosLosCursos() {
        return this.repositorioCursos.findAll();
    }

    public Curso obtenerPorId(Long id) {
        return this.repositorioCursos.findById(id).orElse(null);
    }

    public Curso agregarCurso(Curso curso) {
        return this.repositorioCursos.save(curso);
    }

    public Curso actualizarCurso(Curso curso) {
        return this.repositorioCursos.save(curso);
    }

    public void eliminarCurso(Long id){
        this.repositorioCursos.deleteById(id);
    }

}
