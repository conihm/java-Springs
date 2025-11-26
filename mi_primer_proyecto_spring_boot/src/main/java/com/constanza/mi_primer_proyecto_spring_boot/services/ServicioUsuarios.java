package com.constanza.mi_primer_proyecto_spring_boot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.constanza.mi_primer_proyecto_spring_boot.models.Usuario;
import com.constanza.mi_primer_proyecto_spring_boot.repositories.RepositorioUsuarios;

@Service
public class ServicioUsuarios {
    
    @Autowired
    private RepositorioUsuarios repositorioUsuarios;

    public Usuario obtenerUsuarioPorId(Long id){
        return this.repositorioUsuarios.findById(id).orElse(null);
    }

    public Usuario obtenerUsuarioPorEmail(String email){
        return this.repositorioUsuarios.findByEmail(email).orElse(null);
    }

    public Usuario crearUsuario(Usuario usuario){
        return this.repositorioUsuarios.save(usuario);
    }

    public Usuario actualizarUsuario(Usuario usuario){
        return this.repositorioUsuarios.save(usuario);
    }

    public void eliminarUsuario(Long id){
        this.repositorioUsuarios.deleteById(id);
    }
}
