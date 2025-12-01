package com.constanzahurtado.login_registro.services;

import org.springframework.data.repository.CrudRepository;
import org.springframework.validation.BindingResult;

import com.constanzahurtado.login_registro.models.Usuario;


public interface ServicioUsuarios extends CrudRepository<Usuario,Long> {

    public Usuario obtenerPorCorreo(Object correo);

    BindingResult validarCorreoYPassword(BindingResult validaciones, Usuario usuario);

    BindingResult validarPasswords(BindingResult validaciones, Usuario usuario);

    Usuario crearUsuario(Usuario usuario);

    
}
