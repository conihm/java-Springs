<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Agregar Cancion</title>
        <link rel="stylesheet" href="/css/styles.css">
    </head>
    <body>
        <h1>Agregar Cancion:</h1>
        <form:form action="/canciones/procesa/agregar" method="POST" modelAttribute="cancion">
            <p>
                <form:label path="titulo">Título:</form:label>
                <form:input type="text" path="titulo"/>
                <form:errors path="titulo"/>
            </p>
            <p>
                <form:label path="artista">Artista:</form:label>
                <form:input type="text" path="artista"/>
                <form:errors path="artista"/>
            </p>
            <p>
                <form:label path="album">Álbum:</form:label>
                <form:input type="text" path="album"/>
                <form:errors path="album"/>
            </p>
            <p>
                <form:label path="genero">Género:</form:label>
                <form:input type="text" path="genero"/>
                <form:errors path="genero"/>
            </p>
            <p>
                <form:label path="idioma">Idioma:</form:label>
                <form:input type="text" path="idioma"/>
                <form:errors path="idioma"/>
            </p>
            
            <input type="submit" value="Crear"/>
        </form:form> 
        <a href="/canciones">Volver</a>
    </body>
</html>