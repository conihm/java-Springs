<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Detalle del Videojuego</title>
        <link rel="stylesheet" href="/css/styles.css">
    </head>
    <body>
        <div id="detalle">
            <div>
                <img src="${videojuego.portada}"/>
                <div>
                    <h1>${videojuego.nombre}</h1>
                    <ul>
                        <li>Rating: &#160;&#160;<b>${videojuego.rating}</b> <span>&#9733;</span></li>
                        <li>Fecha Lanzamiento: &#160;&#160;<b>${videojuego.fechaLanzamiento}</b></li>
                        <li><p>${videojuego.descripcion}</p></li>
                    </ul>
                </div>
            </div>
            <a href="/getAll">Volver</a>
        </div>
    </body>
</html>