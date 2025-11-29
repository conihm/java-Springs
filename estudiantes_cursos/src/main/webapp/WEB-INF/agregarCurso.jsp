 <%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
	    <meta charset="UTF-8">
        <title>Agregar Curso</title>
        <link rel="stylesheet" href="/css/styles.css">
    </head>
    <body>
        <h1>Agregar Curso:</h1>
        <form:form action="/cursos/procesa/agregar" method="POST" modelAttribute="curso">
            <p>
                <form:label path="nombre">Nombre:</form:label>
                <form:input type="text" path="nombre"/>
                <form:errors path="nombre" style="color:red"/>
            </p>
            <p>
                <label>Estudiantes para inscripción:</label>
                <select name="idEstudiantes" multiple size="4">
                    <c:forEach var="estudiante" items="${estudiantes}" >
                        <option value="${estudiante.id}">${estudiante.nombre} ${estudiante.apellido}</option>
                    </c:forEach>
                </select>
            </p>
            <button type="submit">Agregar Curso</button>
        </form:form> 
        <a href="/cursos">Volver</a>
    </body>
</html>