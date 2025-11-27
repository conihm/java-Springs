package com.constanza.mi_primer_proyecto_spring_boot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.constanza.mi_primer_proyecto_spring_boot.models.Resena;
import com.constanza.mi_primer_proyecto_spring_boot.repositories.RepositorioResenas;

@Service
public class ServicioResenas {
    
    @Autowired
    private RepositorioResenas repositorioResenas;

    public Resena crearResena(Resena resena) {
        return this.repositorioResenas.save(resena);
    }
    
}
