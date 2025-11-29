<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
		<meta charset="UTF-8">
        <title>Cursos</title>
        <link rel="stylesheet" href="/css/styles.css">
    </head>
    <body>
        <div>
	       <div>
	            <h1>Cursos</h1>
	            <ul class="cursos">
		            <c:forEach var="curso" items="${cursos}">
			            <li>
			                <p>${curso.nombre}</p>
			                <a href="/cursos/detalles/${curso.id}">Estudiantes inscritos</a>
			            </li>
		            </c:forEach>
	            </ul>
	        </div>
			<div>
				<a href="/cursos/formulario/agregar">Agregar nuevo curso</a>
			</div>
			<div>
				<a href="/estudiantes">Ir a Estudiantes</a>
			</div>
        </div>
        <script src="/js/script.js"></script>
    </body>
</html>