package com.constanzahurtado.login_registro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.constanzahurtado.login_registro.models.Usuario;
import com.constanzahurtado.login_registro.services.ServicioUsuarios;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


@Controller
public class ControladorUsuarios {

    @Autowired
    private ServicioUsuarios servicioUsuarios;

    @GetMapping("/") // Form login
    public String inicio(Model modelo) {
        modelo.addAttribute("usuario", new Usuario());
        return "index.jsp";
    }

    @PostMapping("/procesa/login") // Procesa info form login
    public String login(@Valid @ModelAttribute("usuario") Usuario loginUsuario,
            BindingResult validaciones,
            HttpSession session) {
        validaciones = this.servicioUsuarios.validarCorreoYPassword(validaciones, loginUsuario);
        if (validaciones.hasErrors()) {
            return "index.jsp";
        }
        Usuario usuario = this.servicioUsuarios.obtenerPorCorreo(loginUsuario.getCorreo());
        session.setAttribute("nombreCompletoUsuario", usuario.getNombre() + " " + usuario.getApellido());
        session.setAttribute("idUsuario", usuario.getId());
        return "redirect:/frases";
    }

    @PostMapping("/procesa/registro") // Procesa info form registro
    public String register(@Valid @ModelAttribute("usuario") Usuario usuario,
            BindingResult validaciones,
            HttpSession session) {
        validaciones = this.servicioUsuarios.validarPasswords(validaciones, usuario);
        if (validaciones.hasErrors()) {
            return "inicio.jsp";
        }
        Usuario usuarioCreado = this.servicioUsuarios.crearUsuario(usuario);
        session.setAttribute("nombreCompletoUsuario", usuarioCreado.getNombre() + " " + usuarioCreado.getApellido());
        session.setAttribute("idUsuario", usuarioCreado.getId());
        return "inicio.jsp";
    }

}