package com.constanza.mi_primer_proyecto_spring_boot.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.constanza.mi_primer_proyecto_spring_boot.models.Videojuego;

@Repository
public interface RepositorioVideojuegos extends CrudRepository<Videojuego, Long> {
    
}
