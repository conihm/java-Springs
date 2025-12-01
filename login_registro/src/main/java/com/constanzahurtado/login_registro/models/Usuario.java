package com.constanzahurtado.login_registro.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotBlank(message = "El campo no puede estar en blanco.")
    @Size(min = 3, max = 15, message = "El campo debe contener entre 3 y 15 caracteres.")
    private String nombreUsuario;

    @NotBlank(message = "El campo no puede estar en blanco.")
    @Size(min = 8, message = "El password necesita tener al menos 8 catacteres.")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$", message = "El password necesita incluir al menos una letra mayúscula, una letra minúscula y un número")
    private String password;

    @Transient
    private String confirmarPassword;

    @Email(message = "Por favor ingresa un correo válido.")
    private String email;


    @NotBlank(message = "El campo no puede estar en blanco.")
    @Size(min = 3, message = "El campo debe contener al menos 3 caracteres.")
    @Pattern(regexp = "^[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]+$", message = "El campo solo puede contener letras y no debe incluir números.")
    private String nombre;

    @NotBlank(message = "El campo no puede estar en blanco.")
    @Size(min = 3, message = "El campo debe contener al menos 3 caracteres.")
    @Pattern(regexp = "^[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]+$", message = "El campo solo puede contener letras y no debe incluir números.")
    private String apellido;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(updatable = false)
    @Past(message = "Fecha inválida. Proporcione una fecha pasada.")
    private LocalDate fechaNacimiento;

    @CreatedDate
    @Column(name = "fecha_creacion", updatable = false)
    private LocalDateTime fechaCreacion;

    @LastModifiedDate
    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;

    public Usuario() {
    }

    public Usuario(Long id,
            @NotBlank(message = "El campo no puede estar en blanco.") @Size(min = 3, max = 15, message = "El campo debe contener entre 3 y 15 caracteres.") String nombreUsuario,
            @NotBlank(message = "El campo no puede estar en blanco.") @Size(min = 8, message = "El password necesita tener al menos 8 catacteres.") @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$", message = "El password necesita incluir al menos una letra mayúscula, una letra minúscula y un número") String password,
            String confirmarPassword, @Email(message = "Por favor ingresa un correo válido.") String email,
            @NotBlank(message = "El campo no puede estar en blanco.") @Size(min = 3, message = "El campo debe contener al menos 3 caracteres.") String nombre,
            @NotBlank(message = "El campo no puede estar en blanco.") @Size(min = 3, message = "El campo debe contener al menos 3 caracteres.") String apellido,
            @Past(message = "Fecha inválida. Proporcione una fecha pasada.") LocalDate fechaNacimiento,
            LocalDateTime fechaCreacion, LocalDateTime fechaActualizacion) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.confirmarPassword = confirmarPassword;
        this.email = email;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
    }

    @Override
    public String toString() {
        return "Usuario [id=" + id + ", nombreUsuario=" + nombreUsuario + ", password=" + password
                + ", confirmarPassword=" + confirmarPassword + ", email=" + email + ", nombre=" + nombre + ", apellido="
                + apellido + ", fechaNacimiento=" + fechaNacimiento + ", fechaCreacion=" + fechaCreacion
                + ", fechaActualizacion=" + fechaActualizacion + "]";
    }

    @PrePersist
    protected void onCreate() {
        this.fechaCreacion = LocalDateTime.now();
        this.fechaActualizacion = this.fechaCreacion;
    }
    @PreUpdate
    protected void onUpdate() {
        this.fechaActualizacion = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmarPassword() {
        return confirmarPassword;
    }

    public void setConfirmarPassword(String confirmarPassword) {
        this.confirmarPassword = confirmarPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public Object getCorreo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCorreo'");
    }

    

}

