package com.constanzahurtado.login_registro.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginUsuario {

    @NotBlank(message = "El correo es requerido")
    @Email(message = "Ingresa un correo válido")
    private String email;

    @NotBlank(message = "La contraseña es requerida")
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
    private String password;

    public LoginUsuario() {}

    

    public LoginUsuario(
            @NotBlank(message = "El correo es requerido") @Email(message = "Ingresa un correo válido") String email,
            @NotBlank(message = "La contraseña es requerida") @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres") String password) {
        this.email = email;
        this.password = password;
    }



    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}