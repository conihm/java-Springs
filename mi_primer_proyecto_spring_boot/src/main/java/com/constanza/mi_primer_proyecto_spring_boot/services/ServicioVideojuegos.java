package com.constanza.mi_primer_proyecto_spring_boot.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.constanza.mi_primer_proyecto_spring_boot.models.Videojuego;
import com.constanza.mi_primer_proyecto_spring_boot.repositories.RepositorioVideojuegos;

@Service
public class ServicioVideojuegos {
    
    @Autowired
    private RepositorioVideojuegos repositorioVideojuegos;

     public List<Videojuego> obtenerTodosLosVideojuegos() {
        return (List<Videojuego>) this.repositorioVideojuegos.findAll();
    }

    public Videojuego obtenerPorId(Long id) {
        return this.repositorioVideojuegos.findById(id).orElse(null);
    }

    public Videojuego crearVideojuego(Videojuego videojuego){
        return this.repositorioVideojuegos.save(videojuego);
    }

    public Videojuego actualizarVideojuego(Videojuego videojuego){
        return this.repositorioVideojuegos.save(videojuego);
    }

    public void eliminarVideojuego(Long id) {
        this.repositorioVideojuegos.deleteById(id);
    }
    
}
