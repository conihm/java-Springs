package com.constanza.mi_primer_proyecto_spring_boot.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;



@Entity
@Table(name = "usuarios")
    
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String nombre;
    
    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;
    
    @Column(nullable = false, columnDefinition = "DOUBLE DEFAULT 200.00")
    private Double coins = 200.0;

    @OneToOne
    @JoinColumn(name = "id_videojuego")
    @Transient
    private Videojuego videojuego;

    @ManyToMany
    @JoinTable( name = "usuarios_videojuegos",
                joinColumns = @JoinColumn(name = "id_usuario"),
                inverseJoinColumns = @JoinColumn(name = "id_videojuego")
    )
    private List<Videojuego> comprados;

    
    public Usuario() {
    }

    public Usuario(String nombre, String apellido, String email, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.videojuego = new Videojuego();
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    public Videojuego getVideojuego() {
        return videojuego;
    }

    public void setVideojuego(Videojuego videojuego) {
        this.videojuego = videojuego;
    }

    

    
    @Override
    public String toString() {
        return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
                + ", password=" + password + ", coins=" + coins + ", videojuego=" + videojuego + ", comprados="
                + comprados + "]";
    }

    public Double getCoins() {
        return coins;
    }

    public void setCoins(Double coins) {
        this.coins = coins;
    }

    public List<Videojuego> getComprados() {
        return comprados;
    }

    public void setComprados(List<Videojuego> comprados) {
        this.comprados = comprados;
    }

    

}