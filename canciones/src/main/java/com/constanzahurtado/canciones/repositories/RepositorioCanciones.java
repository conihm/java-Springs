package com.constanzahurtado.canciones.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.constanzahurtado.canciones.models.Cancion;

@Repository
public interface RepositorioCanciones extends CrudRepository<Cancion, Long> {

    public List<Cancion> findAll();
 
    
}