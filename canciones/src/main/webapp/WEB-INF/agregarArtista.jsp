<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
	    <meta charset="UTF-8">
        <title>Agregar Artista</title>
        <link rel="stylesheet" href="/css/styles.css">
    </head>
    <body>
        <h1>Agregar Artista:</h1>
        <form:form action="/artistas/procesa/agregar" method="POST" modelAttribute="artista">
            <p>
                <form:label path="nombre">Nombre:</form:label>
                <form:input type="text" path="nombre"/>
                <form:errors path="nombre" style="color:red"/>
            </p>
            <p>
                <form:label path="apellido">Apellido:</form:label>
                <form:input type="text" path="apellido"/>
                <form:errors path="apellido" style="color:red"/>
            </p>
            <p>
                <form:label path="biografia">Biografía:</form:label>
                <form:textarea path="biografia"></form:textarea>
                <form:errors path="biografia" style="color:red"/>
            </p>
    
            
            <button type="submit">Agregar Artista</button>
        </form:form> 
        <a href="/canciones">Volver</a>
    </body>
</html>