<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Detalle del Curso</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <div id="detalle"> 
        <h1>Curso: ${curso.nombre}</h1>
        <h3>Estudiantes inscritos:</h3>
        <ul>
            <c:if test="${empty curso.estudiantes}">
                <li><i>No hay estudiantes inscritos.</i></li>
            </c:if>
            <c:forEach var="estudiante" items="${curso.estudiantes}">
                <li>
                    ${estudiante.nombre} ${estudiante.apellido}
                    <a href="/estudiantes/detalles/${estudiante.id}">(Ver Perfil)</a>
                </li>
            </c:forEach>
        </ul>

        <hr>

        <h3>Inscribir nuevos alumnos:</h3>
        
        <c:if test="${empty noInscritos}">
            <p style="color: green;"><i>¡Todos los estudiantes disponibles ya están inscritos!</i></p>
        </c:if>

        <c:if test="${not empty noInscritos}">
            <form action="/cursos/procesa/inscribir/${curso.id}" method="POST">
                <p>Select multiple:</p>
                <select name="idEstudiantes" multiple size="5" style="width: 200px;">
                    <c:forEach var="e" items="${noInscritos}">
                        <option value="${e.id}">${e.nombre} ${e.apellido}</option>
                    </c:forEach>
                </select>
                <br><br>
                <button type="submit">Inscribir Seleccionados</button>
            </form>
        </c:if>

        <br>
        <a href="/cursos">Volver a Cursos</a>
    </div>
</body>
</html>