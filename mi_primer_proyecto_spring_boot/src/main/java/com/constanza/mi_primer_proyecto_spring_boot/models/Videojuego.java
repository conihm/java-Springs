package com.constanza.mi_primer_proyecto_spring_boot.models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Videojuego {
    private String nombre, descripcion, portada;
    private LocalDate fechaLanzamiento;
    private Double rating;
    //private ArrayList<String> generos, plataformas;
    private Long id;
    
    
    public Videojuego() {

    }
  
    
   /*  @Override
    public String toString() {
        return "Videojuego [nombre=" + nombre + ", descripcion=" + descripcion + ", portada=" + portada
                + ", fechaLanzamiento=" + fechaLanzamiento + ", rating=" + rating + ", generos=" + generos
                + ", plataformas=" + plataformas + "]";
    }*/

    

    public Videojuego(Long id, String nombre, String descripcion, String portada, LocalDate fechaLanzamiento, Double rating,
            ArrayList<String> generos, ArrayList<String> plataformas) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.portada = portada;
        this.fechaLanzamiento = fechaLanzamiento;
        this.rating = rating;
        //this.generos = generos;
        //this.plataformas = plataformas;
        this.id = id;
    }

    public Videojuego(Long id, String nombre, String descripcion, String portada, LocalDate fechaLanzamiento, Double rating) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.portada = portada;
        this.fechaLanzamiento = fechaLanzamiento;
        this.rating = rating;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Videojuego [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", portada=" + portada
                + ", fechaLanzamiento=" + fechaLanzamiento + ", rating=" + rating + "]";
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public LocalDate getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    
    /*

    public ArrayList<String> getGeneros() {
        return generos;
    }

    public void setGeneros(ArrayList<String> generos) {
        this.generos = generos;
    }

    public ArrayList<String> getPlataformas() {
        return plataformas;
    }

    public void setPlataformas(ArrayList<String> plataformas) {
        this.plataformas = plataformas;
    }

    */

    
}
