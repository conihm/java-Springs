package com.constanzahurtado.canciones.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.constanzahurtado.canciones.models.Cancion;
import com.constanzahurtado.canciones.repositories.RepositorioCanciones;

@Service
public class ServicioCanciones {
    
    @Autowired
    private RepositorioCanciones repositorioCanciones;


    public Cancion obtenerCancionPorId(Long id) {
        return this.repositorioCanciones.findById(id).orElse(null);
    }

    public Cancion agregarCancion(Cancion cancion) {
        return this.repositorioCanciones.save(cancion);
    }

    public Cancion actualizarCancion(Cancion cancion) {
        return this.repositorioCanciones.save(cancion);
    }

    public void eliminarCancion(Long id) {
        this.repositorioCanciones.deleteById(id);
    }

    public List<Cancion> obtenerTodasLasCanciones() {
        return this.repositorioCanciones.findAll();
    }
    

}
