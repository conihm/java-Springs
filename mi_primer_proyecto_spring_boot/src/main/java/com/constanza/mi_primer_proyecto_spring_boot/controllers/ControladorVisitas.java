package com.constanza.mi_primer_proyecto_spring_boot.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class ControladorVisitas {

    public ControladorVisitas() {
    }

    @GetMapping("/visitas")
    public String visitas(HttpSession session) {
        Integer conteo = (Integer) session.getAttribute("numDeVisitas");
        if(conteo == null)
            conteo = 0;
        session.setAttribute("numDeVisitas", conteo);
        return "visitas.jsp";
    }

    @PostMapping("/agregarVisita")
    public String agregaVisitaManualmente(HttpSession session) {
        Integer conteo = (Integer) session.getAttribute("numDeVisitas");
        if(conteo == null)
            conteo = 0;
        conteo++;

        session.setAttribute("numDeVisitas", conteo);
        return "redirect:/visitas";
    }
}
    