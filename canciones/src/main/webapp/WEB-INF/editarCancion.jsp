<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Editar Cancion</title>
        <link rel="stylesheet" href="/css/styles.css">
    </head>
    <body>
        <h1>Editar Cancion:</h1>
            <form:form action="/canciones/procesa/editar" method="POST" modelAttribute="cancion">            
            <input type="hidden" name="_method" value="PUT"/>
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
            <p>
                <input type="hidden" name="id" value="${cancion.id}"/>
                <input type="hidden" name="fechaCreacion" value="${cancion.fechaCreacion}"/>
                <input type="hidden" name="fechaActualizacion" value="${cancion.fechaActualizacion}"/>    
            </p>
                
            <input type="submit" value="Editar"/>
        </form:form> 
        <a href="/canciones">Volver</a>
    </body>
</html>