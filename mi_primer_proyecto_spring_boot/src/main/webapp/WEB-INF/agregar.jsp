<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Agregar Videojuego</title>
        <link rel = "stylesheet" href = "/css/styles.css">

    </head>
    <body>
        <h1>Agregar Videojuego: </h1>
        <form:form action="/add" method = "POST" modelAttribute ="videojuego">
            <form:label path="nombre">Nombre:</form:label>
            <form:input type="text" path="nombre" />
            <form:errors path="nombre" />

            <form:label path="descripcion">Descripción:</form:label>
            <form:textarea path="descripcion"></form:textarea>
            <form:errors path="descripcion" />

            <form:label path="portada">Portada:</form:label>
            <form:input type="text" path="portada" />
            <form:errors path="portada" />

            <form:label path="fechaLanzamiento">Fecha Lanzamiento:</form:label>
            <form:input type="date" path="fechaLanzamiento" />
            <form:errors path="fechaLanzamiento" />

            <form:label path="rating">Rating:</form:label>
            <form:input type="number" path="rating" step="0.5" />
            <form:errors path="rating" />

		    <input type="hidden" name="creador" value="${usuario.id}"/>


            <input type="submit" value="Crear"/>
        </form:form>
        <a href="/getAll">Volver</a>
    </body>

</html>