package com.constanza.mi_primer_proyecto_spring_boot.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import org.hibernate.validator.constraints.URL;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "videojuegos")
public class Videojuego {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message = "Este campo es obligatorio.")
    @Size(min = 5, max = 40, message = "Debe contener entre 5 y 40 caracteres.")
    private String nombre;

    @Size(max = 400, message = "Debe contener menos de 400 caracteres.")
    private String descripcion;
    
    @URL(message = "No es una URL válida.")
    private String portada;
    
    @NotNull(message = "Este campo es obligatorio.")
    private LocalDate fechaLanzamiento;
    
    @Min(value = 1, message = "El valor debe ser al menos 1.")
    @Max(value = 5, message = "El valor debe ser a lo más 5.")
    private Double rating;
    
    private Double precio;

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario creador;
    
    //private ArrayList<String> generos, plataformas;
    
    @OneToMany(mappedBy = "videojuego")
    private List<Resena> resenas;

    @ManyToMany(mappedBy = "comprados", fetch = FetchType.LAZY)
    @Transient
    private Set<Usuario> compradores;

    public Videojuego() {

    }
  


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

    public Videojuego(String nombre, String descripcion, String portada, LocalDate fechaLanzamiento, Double rating, Double precio, Usuario creador) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.portada = portada;
        this.fechaLanzamiento = fechaLanzamiento;
        this.rating = rating;
        this.precio = (precio != 0) ? precio : this.generarPrecioRandom();
        this.creador = creador;
        this.resenas = new ArrayList<>();
        this.compradores = new HashSet<Usuario>();

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

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Usuario getCreador() {
        return creador;
    }

    public void setCreador(Usuario creador) {
        this.creador = creador;
    }

    public List<Resena> getResenas() {
        return resenas;
    }

    public void setResenas(List<Resena> resenas) {
        this.resenas = resenas;
    }

    @Override
    public String toString() {
        return "Videojuego [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", portada=" + portada
                + ", fechaLanzamiento=" + fechaLanzamiento + ", rating=" + rating + ", precio=" + precio + ", creador="
                + creador + ", resenas=" + resenas + ", compradores=" + compradores + "]";
    }

    private double generarPrecioRandom() {
        return Math.round((ThreadLocalRandom.current().nextDouble(5.0, 150.0)) * 100.00 )/ 100.00;
    }

    @PrePersist
    public void asignarPrecioAleatorio() {
        if(precio == null)
            precio = generarPrecioRandom();
    }

    public Set<Usuario> getCompradores() {
        return compradores;
    }

    public void setCompradores(Set<Usuario> compradores) {
        this.compradores = compradores;
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
