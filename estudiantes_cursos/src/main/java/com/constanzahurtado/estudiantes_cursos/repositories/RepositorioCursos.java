package com.constanzahurtado.estudiantes_cursos.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.constanzahurtado.estudiantes_cursos.models.Curso;

@Repository
public interface RepositorioCursos extends CrudRepository<Curso,Long> {
    public List<Curso> findAll();


}
