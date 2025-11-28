package com.constanzahurtado.canciones.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.constanzahurtado.canciones.models.Artista;

@Repository
public interface RepositorioArtistas extends CrudRepository<Artista,Long> {
    
    public List<Artista> findAll();
}
