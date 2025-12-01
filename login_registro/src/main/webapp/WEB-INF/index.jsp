


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login y Registro</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <h1 style="text-align:center">Bienvenido</h1>
    
    <div class="container">
        <div class="form-box">
            <h2>Registrarse</h2>
            <form:form action="/procesa/registro" method="POST" modelAttribute="nuevoUsuario">
                
                <div>
                    <form:label path="nombre">Nombre:</form:label>
                    <form:input path="nombre" />
                    <form:errors path="nombre" class="error"/>
                </div>

                <div>
                    <form:label path="apellido">Apellido:</form:label>
                    <form:input path="apellido" />
                    <form:errors path="apellido" class="error"/>
                </div>
                
                <div>
                    <form:label path="email">Correo:</form:label>
                    <form:input type="email" path="email" />
                    <form:errors path="email" class="error"/>
                </div>

                <div>
                    <form:label path="nombreUsuario">Usuario (Nick):</form:label>
                    <form:input path="nombreUsuario" />
                    <form:errors path="nombreUsuario" class="error"/>
                </div>
                
                <div>
                    <form:label path="password">Contraseña:</form:label>
                    <form:password path="password" />
                    <form:errors path="password" class="error"/>
                </div>
                
                <div>
                    <form:label path="confirmarPassword">Confirmar Pass:</form:label>
                    <form:password path="confirmarPassword" />
                    <form:errors path="confirmarPassword" class="error"/>
                </div>
                
                <div>
                    <form:label path="fechaNacimiento">F. Nacimiento:</form:label>
                    <form:input type="date" path="fechaNacimiento" />
                    <form:errors path="fechaNacimiento" class="error"/>
                </div>

                <button type="submit">Registrarse</button>
            </form:form>
        </div>

        <div class="form-box">
            <h2>Iniciar Sesión</h2>
            <form:form action="/procesa/login" method="POST" modelAttribute="nuevoLogin">
                
                <div>
                    <form:label path="email">Correo:</form:label>
                    <form:input type="email" path="email" />
                    <form:errors path="email" class="error"/>
                </div>
                
                <div>
                    <form:label path="password">Contraseña:</form:label>
                    <form:password path="password" />
                    <form:errors path="password" class="error"/>
                </div>

                <button type="submit">Entrar</button>
            </form:form>
        </div>
        
    </div>
</body>
</html>