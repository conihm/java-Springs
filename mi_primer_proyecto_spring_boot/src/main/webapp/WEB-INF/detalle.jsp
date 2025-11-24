<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset ="ISO-8859-1">
        <title>Detalle del Videojuego</title>
        <link rel = "stylesheet" href = "/css/styles.css">

    </head>
    <body>
        <h1>${juego.nombre}</h1>
         <img src="${juego.portada}" width = "200px"/>,
        <ul>
            <li>Fecha lanzamiento: <b>${juego.fechaLanzamiento}</b>,</li>
            <li>Rating: ${juego.rating}</li>
        </ul>
        <p>${juego.descripcion}</p>
            <a href="/getAll">Volver</a>
            </li>
    </body>

</html>
