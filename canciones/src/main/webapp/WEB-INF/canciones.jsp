<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
		<meta charset="UTF-8">
        <title>Canciones</title>
        <link rel="stylesheet" href="/css/styles.css">
    </head>
    <body>
        <div>
	       <div>
	            <h1>Canciones</h1>
	            <ul class="canciones">
		            <c:forEach var="cancion" items="${canciones}">
			            <li>
			                <h3>${cancion.titulo}</h3>
			                <a href="/canciones/detalles/${cancion.id}">Detalles</a>
			            </li>
		            </c:forEach>
	            </ul>
	        </div>
			<div>
				<a href="/canciones/formulario/agregar">Agregar nueva canción</a>
			</div>
			<div>
				<a href="/artistas">Ir a artistas</a>
			</div>
        </div>
        <script src="/js/script.js"></script>
    </body>
</html>