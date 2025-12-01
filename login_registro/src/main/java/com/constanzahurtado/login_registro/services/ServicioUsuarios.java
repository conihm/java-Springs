package com.constanzahurtado.login_registro.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.constanzahurtado.login_registro.models.LoginUsuario;
import com.constanzahurtado.login_registro.models.Usuario;
import com.constanzahurtado.login_registro.repositories.RepositorioUsuarios;

@Service
public class ServicioUsuarios {

    @Autowired
    private RepositorioUsuarios repositorioUsuarios;

    // LÓGICA DE REGISTRO
    public Usuario registrar(Usuario nuevoUsuario, BindingResult result) {
        
        // 1. Contraseñas coinciden?
        if (!nuevoUsuario.getPassword().equals(nuevoUsuario.getConfirmarPassword())) {
            result.rejectValue("confirmarPassword", "Matches", "Las contraseñas no coinciden");
        }

        // 2. correo existe?
        if (repositorioUsuarios.findByEmail(nuevoUsuario.getEmail()) != null) {
            result.rejectValue("email", "Unique", "El correo ya está registrado");
        }
        
        // 2.5 nick existe?
        if(repositorioUsuarios.findByNombreUsuario(nuevoUsuario.getNombreUsuario()) != null) {
        	result.rejectValue("nombreUsuario", "Unique", "El nombre de usuario ya existe");
        }

        // Si hay errores en el BindingResult, retornamos null (no guardamos). Errores del binding
        if (result.hasErrors()) {
            return null;
        }

        // 3. Encriptar contraseña
        String hashed = BCrypt.hashpw(nuevoUsuario.getPassword(), BCrypt.gensalt());
        nuevoUsuario.setPassword(hashed);

        // 4. Guardar
        return repositorioUsuarios.save(nuevoUsuario);
    }

    // LÓGICA DE LOGIN
    public Usuario login(LoginUsuario nuevoLogin, BindingResult result) {
        
        // 1. Buscar usuario por correo
        Usuario usuarioRegistrado = repositorioUsuarios.findByEmail(nuevoLogin.getEmail());

        if (usuarioRegistrado == null) {
            result.rejectValue("email", "Matches", "Correo no encontrado");
            return null;
        }

        // 2. Verificar contraseña encriptada
        if (!BCrypt.checkpw(nuevoLogin.getPassword(), usuarioRegistrado.getPassword())) {
            result.rejectValue("password", "Matches", "Contraseña incorrecta");
            return null;
        }

        if (result.hasErrors()) {
            return null;
        }

        return usuarioRegistrado;
    }
}