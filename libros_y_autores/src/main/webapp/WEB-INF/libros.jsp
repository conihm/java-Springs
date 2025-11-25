<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Lista de todos los libros</title>
	</head>
	<body>
		<h1>Lista de libro</h1>
		<ul>
			<c:forEach var="nombre" items="${listaLibros.keySet()}">
			
				<li>
					<a href="/libros/${nombre}">
						<c:out value="${nombre}"/>				
					</a>
				</li>		
			</c:forEach>
		</ul>
		<a href="/libro/formulario">Agregar nuevo libro</a>
	</body>
</html>