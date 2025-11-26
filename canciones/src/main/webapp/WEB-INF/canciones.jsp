<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Canciones</title>
        <link rel="stylesheet" href="/css/styles.css">
    </head>
    <body>
        <div class="content">
	       <div class="vComunidad">
	            <h1>Canciones</h1>
	            <ul class="videojuegos">
		            <c:forEach var="cancion" items="${canciones}">
			            <li>
			                <h3>${cancion.titulo}</h3>
			                <a href="/canciones/detalles/${cancion.id}">Detalles</a>
			            </li>
		            </c:forEach>
	            </ul>
	        </div>
        </div>
        <script src="/js/script.js"></script>
    </body>
</html>