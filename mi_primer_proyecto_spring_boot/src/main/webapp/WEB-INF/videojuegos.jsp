<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset ="ISO-8859-1">
        <title>Videojuegos</title>
        <link rel = "stylesheet" href = "/css/styles.css">
    </head>
    <body>
        <a href="/form/add">Crear Videojuegos</a>
        <h1>Videojuegos:  </h1>
        <ul>
            <c:forEach var="juego" items="${videojuegos}">
                <img src="${juego.portada}" width = "200px"/>,
                Nombre: <b>${juego.nombre}</b>, 
                Fecha lanzamiento: <b>${juego.fechaLanzamiento}</b>,
                <a href="detail/${juego.id}">Detalles</a>
                </li>
            </c:forEach>
        </ul>
        <script src="/js/script.js"></script>
    </body>

</html>
