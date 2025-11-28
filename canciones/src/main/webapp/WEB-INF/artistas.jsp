<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
	<meta charset="UTF-8">
        <title>Artistas</title>
        <link rel="stylesheet" href="/css/styles.css">
    </head>
    <body>
        <div>
	       	<div>
	            <h1>Artistas</h1>
	            <ul class="artistas">
		            <c:forEach var="artista" items="${artistas}">
			            <li>
			                <a href="/artistas/detalles/${artista.id}">${artista.nombre} ${artista.apellido}</a>
			            </li>
		            </c:forEach>
	            </ul>
	        </div>
			<div>
				<a href="/canciones">Ir a canciones</a>
			</div>
        </div>
        <script src="/js/script.js"></script>
    </body>
</html>