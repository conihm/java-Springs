package com.constanzahurtado.estudiantes_cursos.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.constanzahurtado.estudiantes_cursos.models.Estudiante;

@Repository
public interface RepositorioEstudiantes extends CrudRepository<Estudiante,Long> {
    public List<Estudiante> findAll();
}
