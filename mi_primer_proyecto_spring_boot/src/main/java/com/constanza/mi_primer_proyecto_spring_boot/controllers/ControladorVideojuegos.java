package com.constanza.mi_primer_proyecto_spring_boot.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.constanza.mi_primer_proyecto_spring_boot.interfaces.ManejoDeFechas;
import com.constanza.mi_primer_proyecto_spring_boot.models.Resena;
import com.constanza.mi_primer_proyecto_spring_boot.models.Usuario;
import com.constanza.mi_primer_proyecto_spring_boot.models.Videojuego;
import com.constanza.mi_primer_proyecto_spring_boot.services.ServicioResenas;
import com.constanza.mi_primer_proyecto_spring_boot.services.ServicioUsuarios;
import com.constanza.mi_primer_proyecto_spring_boot.services.ServicioVideojuegos;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;


@Controller
public class ControladorVideojuegos implements ManejoDeFechas {

    @Autowired
    private ServicioVideojuegos servicioVideojuegos;
    
    @Autowired
    private ServicioResenas servicioResenas;

    @Autowired
    private ServicioUsuarios servicioUsuarios;

    
   //private ArrayList<Videojuego> videojuegos;

    /*public ControladorVideojuegos() {
        this.videojuegos = new ArrayList<>();
        Videojuego v1 = new Videojuego(1l, "Silent Hill 2",
                "Having received a letter from his deceased wife, James heads to where they shared so many memories, in the hope of seeing her one more time: Silent Hill.",
                "https://shared.fastly.steamstatic.com/store_item_assets/steam/apps/2124490/capsule_616x353.jpg?t=1744248682",
                formatearFecha("08/10/2024"), 4.8);
        Videojuego v2 = new Videojuego(2l, "Outlast",
                "Outlast follows the story of investigative journalist Miles Upshur, that got the lead on the inhuman experiments, performed on the asylum patients.",
                "https://shared.akamai.steamstatic.com/store_item_assets/steam/apps/238320/capsule_616x353.jpg?t=1666817106",
                formatearFecha("03/09/2013"), 4.5);
        Videojuego v3 = new Videojuego(3l, "Resident Evil 2",
                "The story follows the survivors of a zombie virus outbreak in the fictional Raccoon City.",
                "https://shared.akamai.steamstatic.com/store_item_assets/steam/apps/883710/header.jpg?t=1728438541",
                formatearFecha("25/01/2019"), 4.3);
        this.videojuegos.add(v1);
        this.videojuegos.add(v2);
        this.videojuegos.add(v3);
    }*/

    @GetMapping("/getAll")
    public String getVideojuegos(Model modelo, HttpSession session) {

        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) {
            return "redirect:/";
        }
        List<Videojuego> misVideoJuegos = (List<Videojuego>) servicioUsuarios.obtenerUsuarioPorId(usuario.getId()).getComprados();
        modelo.addAttribute("misVideojuegos", misVideoJuegos);
        modelo.addAttribute("videojuegos", servicioVideojuegos.obtenerTodosLosVideojuegos());
        return "videojuegos.jsp";
    }



    /*private Videojuego buscar(Long id) {
        Videojuego v = null;
        for (Videojuego videojuego : this.videojuegos) {
            if (videojuego.getId() == id)
                v = videojuego;
        }
        return v;
    }*/

    @GetMapping("/form/add")
    public String formAgregar(HttpSession session, Model modelo) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) {
            return "redirect:/";
        }
        modelo.addAttribute("videojuego", new Videojuego());
        return "agregar.jsp";
    }

    @PostMapping("/add")
    public String guardar(  @Valid @ModelAttribute("videojuego") Videojuego videojuego, 
                            BindingResult validaciones,
                            HttpSession session) {

        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) {
            return "redirect:/";
        }
        if(validaciones.hasErrors())
            return "agregar.jsp";
        servicioVideojuegos.crearVideojuego(videojuego);
        return "redirect:/getAll";
    }
    /*public String guardar(@RequestParam String nombre,
            @RequestParam String descripcion,
            @RequestParam String portada,
            @RequestParam String fecha_lanzamiento,
            @RequestParam String rating, HttpSession session) {

        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) {
            return "redirect:/";
        }
        Videojuego newJuego = new Videojuego(
                nombre,
                descripcion,
                portada,
                LocalDate.parse(fecha_lanzamiento),
                Double.parseDouble(rating),
                0.0);
        servicioVideojuegos.crearVideojuego(newJuego);
        return "redirect:/getAll";
    }
    public String guardar(@RequestParam String nombre,
            @RequestParam String descripcion,
            @RequestParam String portada,
            @RequestParam String fecha_lanzamiento,
            @RequestParam String rating, HttpSession session) {

        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) {
            return "redirect:/";
        }
        long nuevoId = this.videojuegos.size() + 1;
        Videojuego juego = new Videojuego(nuevoId,
                nombre,
                descripcion,
                portada,
                LocalDate.parse(fecha_lanzamiento),
                Double.parseDouble(rating));
        this.videojuegos.add(juego);
        return "redirect:/getAll";
    }*/

    @GetMapping("/detail/{id}")
    public String detalle(@PathVariable("id") Long id, Model modelo, HttpSession session) {

        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) {
            return "redirect:/";
        }
        Videojuego juego = servicioVideojuegos.obtenerPorId(id);
        modelo.addAttribute("videojuego", juego);
        modelo.addAttribute("resena", new Resena());
        return "detalle.jsp";
    }

    @GetMapping("/form/edit/{id}")
    public String formEditar(   HttpSession session, 
                                Model modelo, 
                                @PathVariable("id") Long id) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) {
            return "redirect:/";
        }
        modelo.addAttribute("videojuego", servicioVideojuegos.obtenerPorId(id));
        return "editar.jsp";
    }

    @PutMapping("/edit")
    public String actualizarVideojuego( @Valid @ModelAttribute("videojuego") Videojuego videojuego,
                                        BindingResult validaciones,
                                        HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) {
            return "redirect:/";
        }
        if(validaciones.hasErrors())
            return "editar.jsp";
        this.servicioVideojuegos.actualizarVideojuego(videojuego);
        return "redirect:/getAll";
    }

    @DeleteMapping("/delete/{id}")
    public String eliminarVideojuego(@PathVariable("id") Long id, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) {
            return "redirect:/";
        }
        this.servicioVideojuegos.eliminarVideojuego(id);
        return "redirect:/getAll";

    }


    @PostMapping("/comment")
    public String comentar(@Valid @ModelAttribute("resena") Resena resena,
                                        BindingResult validaciones,
                                        HttpSession session,
                                        Model modelo) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) {
            return "redirect:/";
        }
        if(validaciones.hasErrors()) {
            Videojuego juego = this.servicioVideojuegos.obtenerPorId(resena.getVideojuego().getId());
            modelo.addAttribute("videojuego", juego);
            return "detalle.jsp";
        }
        this.servicioResenas.crearResena(resena);
        return "redirect:/detail/" + resena.getVideojuego().getId();
    }

    @GetMapping("/buy/{id}")
    public String comprarVideojuego(HttpSession session, 
                                    Model modelo,
                                    @PathVariable("id") Long idJuego) {
        Usuario usuarioSession = (Usuario) session.getAttribute("usuario");
        if (usuarioSession == null) {
            return "redirect:/";
        }
        Usuario usuarioServicio = servicioUsuarios.obtenerUsuarioPorId(usuarioSession.getId());
        Videojuego juegoComprar = servicioVideojuegos.obtenerPorId(idJuego);
        List<Videojuego> juegosUsuario = (List<Videojuego>) usuarioServicio.getComprados();
        juegosUsuario.add(juegoComprar);
        usuarioServicio.setComprados(juegosUsuario);
        Double difCoins = usuarioServicio.getCoins() - juegoComprar.getPrecio();
        usuarioServicio.setCoins(difCoins);
        usuarioSession.setCoins(difCoins);
        servicioUsuarios.actualizarUsuario(usuarioServicio);
        session.setAttribute("usuario", usuarioSession);
        return "redirect:/getAll";  
    }


}