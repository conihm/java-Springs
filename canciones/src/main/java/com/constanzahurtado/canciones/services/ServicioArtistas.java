package com.constanzahurtado.canciones.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.constanzahurtado.canciones.models.Artista;
import com.constanzahurtado.canciones.repositories.RepositorioArtistas;

@Service
public class ServicioArtistas {

    @Autowired
    private RepositorioArtistas repositorioArtistas;

    public Artista obtenerArtistaPorId(Long id) {
        return this.repositorioArtistas.findById(id).orElse(null);
    }

    public Artista agregarArtista(Artista artista) {
        return this.repositorioArtistas.save(artista);
    }

    public Artista actualizarArtista(Artista artista) {
        return this.repositorioArtistas.save(artista);
    }

    public void eliminarArtista(Long id) {
        this.repositorioArtistas.deleteById(id);
    }

    public List<Artista> obtenerTodosLosArtistas() {
        return this.repositorioArtistas.findAll();
    }
    
}
