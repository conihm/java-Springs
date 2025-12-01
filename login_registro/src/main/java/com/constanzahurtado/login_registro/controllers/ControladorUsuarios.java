package com.constanzahurtado.login_registro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.constanzahurtado.login_registro.models.LoginUsuario;
import com.constanzahurtado.login_registro.models.Usuario;
import com.constanzahurtado.login_registro.services.ServicioUsuarios;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControladorUsuarios {

    @Autowired
    private ServicioUsuarios servicioUsuarios;

    // 1. FORMULARIO (GET /) INICIO
    @GetMapping("/")
    public String index(Model model) {
        //  enviar AMBOS objetos vacíos al JSP
        model.addAttribute("nuevoUsuario", new Usuario());
        model.addAttribute("nuevoLogin", new LoginUsuario());
        return "index.jsp";
    }

    // 2. PROCESAR REGISTRO (POST /procesa/registro)
    @PostMapping("/procesa/registro")
    public String registrar(@Valid @ModelAttribute("nuevoUsuario") Usuario nuevoUsuario,
                            BindingResult result,
                            Model model,
                            HttpSession session) {

        // Llamamos al servicio para validaciones extra (duplicados, contraseñas)
        servicioUsuarios.registrar(nuevoUsuario, result);

        if (result.hasErrors()) {
            // Si hay error, volvemos al index.
            // El index espera TAMBIÉN un objeto "nuevoLogin", así que se envía vacío.
            model.addAttribute("nuevoLogin", new LoginUsuario());
            return "index.jsp";
        }

        // Si no hay errores, guardamos en sesión y redirigimos
        session.setAttribute("usuarioId", nuevoUsuario.getId());
        session.setAttribute("usuarioNombre", nuevoUsuario.getNombre());
        return "redirect:/inicio";
    }

    // 3. PROCESAR LOGIN (POST /procesa/login)
    @PostMapping("/procesa/login")
    public String login(@Valid @ModelAttribute("nuevoLogin") LoginUsuario nuevoLogin,
                        BindingResult result,
                        Model model,
                        HttpSession session) {

        Usuario usuario = servicioUsuarios.login(nuevoLogin, result);

        if (result.hasErrors()) {
            // Si hay error, index.
            // El index espera "nuevoUsuario" también, se envía vacío.
            model.addAttribute("nuevoUsuario", new Usuario());
            return "index.jsp";
        }

        // Éxito: Guardamos en sesión
        session.setAttribute("usuarioId", usuario.getId());
        session.setAttribute("usuarioNombre", usuario.getNombre());
        return "redirect:/inicio";
    }
    
    // 4. BIENVENIDA (GET /inicio)
    @GetMapping("/inicio")
    public String inicio(HttpSession session) {
    	// Seguridad básica: si no hay sesión, al login
    	if(session.getAttribute("usuarioId") == null) {
    		return "redirect:/";
    	}
    	return "inicio.jsp";
    }
    
    // 5. LOGOUT (Opcional pero recomendado)
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }
}