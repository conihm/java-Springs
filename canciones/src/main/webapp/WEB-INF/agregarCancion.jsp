<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
	    <meta charset="UTF-8">
        <title>Agregar Cancion</title>
        <link rel="stylesheet" href="/css/styles.css">
    </head>
    <body>
        <h1>Agregar Cancion:</h1>
        <form:form action="/canciones/procesa/agregar" method="POST" modelAttribute="cancion">
            <p>
                <form:label path="titulo">Título:</form:label>
                <form:input type="text" path="titulo"/>
                <form:errors path="titulo" style="color:red"/>
            </p>
            <p>
                <label>Artista:</label>
                <select name="idArtista">
                    <c:forEach var="artista" items="${artistas}" >
                        <option value="${artista.id}">${artista.nombre} ${artista.apellido}</option>
                    </c:forEach>
                </select>
            </p>
            <p>
                <form:label path="album">Álbum:</form:label>
                <form:input type="text" path="album"/>
                <form:errors path="album" style="color:red"/>
            </p>
            <p>
                <form:label path="genero">Género:</form:label>
                <form:input type="text" path="genero"/>
                <form:errors path="genero" style="color:red"/>
            </p>
            <p>
                <form:label path="idioma">Idioma:</form:label>
                <form:input type="text" path="idioma"/>
                <form:errors path="idioma" style="color:red"/>
            </p>
            
            <button type="submit">Agregar Canción</button>
        </form:form> 
        <a href="/canciones">Volver</a>
    </body>
</html>