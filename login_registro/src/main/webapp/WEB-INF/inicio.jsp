<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Inicio</title>
</head>
<body>
    <div style="text-align: center; margin-top: 50px;">
        <h1>Bienvenid@ de vuelta a la aplicación de Login y Registro</h1>
        
        <h3>Hola, <c:out value="${usuarioNombre}" /></h3>
        
        <br>
        <a href="/logout">Cerrar Sesión</a>
    </div>
</body>
</html>