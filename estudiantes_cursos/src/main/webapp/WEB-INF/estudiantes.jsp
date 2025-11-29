<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
		<meta charset="UTF-8">
        <title>Estudiantes</title>
        <link rel="stylesheet" href="/css/styles.css">
    </head>
    <body>
        <div>
	       <div>
	            <h1>Estudiantes</h1>
	            <ul class="estudiantes">
		            <c:forEach var="estudiante" items="${estudiantes}">
			            <li>
			                <p>${estudiante.nombre} ${estudiante.apellido}</p>
			                <a href="/estudiantes/detalles/${estudiante.id}">Cursos</a>
			            </li>
		            </c:forEach>
	            </ul>
	        </div>
			<div>
				<a href="/estudiantes/formulario/agregar">Agregar nuevo estudiante</a>
			</div>
			<div>
				<a href="/Cursos">Ir a cursos</a>
			</div>
        </div>
        <script src="/js/script.js"></script>
    </body>
</html>