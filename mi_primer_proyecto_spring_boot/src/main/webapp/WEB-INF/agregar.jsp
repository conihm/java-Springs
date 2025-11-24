<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Agregar Videojuego</title>
    </head>
    <body>
        <h1>Agregar Videojuego: </h1>
        <form action=/add methods = "POST">
            <label for="nombre">Nombre:</label>
            <input type="text" name="nombre">

            <label for="descripcion">Descripción:</label>
            <textarea name="descripcion"></textarea>

            <label for="portada">Portada:</label>
            <input type="url" name="portada">

            <label for="fechaLanzamiento">Fecha Lanzamiento:</label>
            <input type="date" name="fechaLanzamiento">

            <label for="rating">Rating:</label>
            <input type="number" name="rating" min="0" max ="5" step="0.5">

            <input type="submit" value="Crear">
        </form>
        <a href="/getAll">Volver</a>
    </body>

</html>