<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Cursos de un estudiante</title>
        <link rel="stylesheet" href="/css/styles.css">
    </head>
    <body>
        <div id="detalle"> 
            <h1>${estudiante.nombre} ${estudiante.apellido}</h1>
            <h3>Cursos inscritos</h3>
            <ul class="cursos">
                    <c:if test="${empty estudiante.cursos}">
                        <li style="list-style: none;">
                            <i>Este estudiante aún no está inscrito en ningún curso.</i>
                        </li>
                    </c:if>

                    <c:if test="${!empty estudiante.cursos}">
                        <c:forEach var="curso" items="${estudiante.cursos}">
                            <li>
                                <strong>Nombre: ${curso.nombre}</strong> 
                                <ul>
                                    <li>Fecha de inscripción: ${estudiante.fechaCreacion}</b></li>
                                    <li><a href="/cursos/detalles/${curso.id}">(Ver Curso)</a></b></li>
                                </ul>
                                <br> 
                            </li>
                        </c:forEach>
                    </c:if>    
                </ul>
            <p>
                <a href="/estudiantes">Volver a estudiantes</a>
            </p>
        </div>
    </body>
</html>
