 <%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
	    <meta charset="UTF-8">
        <title>Agregar Estudiante</title>
        <link rel="stylesheet" href="/css/styles.css">
    </head>
    <body>
        <h1>Agregar Estudiante:</h1>
        <form:form action="/estudiantes/procesa/agregar" method="POST" modelAttribute="estudiante">
            <p>
                <form:label path="nombre">Nombre:</form:label>
                <form:input type="text" path="nombre"/>
                <form:errors path="nombre" style="color:red"/>
            </p>
            <p>
                <form:label path="apellido">Apellido:</form:label>
                <form:input type="text" path="apellido"/>
                <form:errors path="apellido" style="color:red"/>
            </p>
            <p>
                <form:label path="edad">Edad:</form:label>
                <form:input type="text" path="edad"/>
                <form:errors path="edad" style="color:red"/>
            </p>
            <p>
                <label>Cursos:</label>
                <select name="idCursos" multiple size="4">
                    <c:forEach var="curso" items="${cursos}" >
                        <option value="${curso.id}">${curso.nombre}</option>
                    </c:forEach>
                </select>
            </p>
            <button type="submit">Agregar Estudiante</button>
        </form:form> 
        <a href="/estudiantes">Volver</a>
    </body>
</html>