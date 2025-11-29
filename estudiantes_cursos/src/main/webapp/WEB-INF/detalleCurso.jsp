<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Detalle del Curso</title>
        <link rel="stylesheet" href="/css/styles.css">
    </head>
    <body>
        <div id="detalle"> 
            <div>
                <h1>${curso.nombre}</h1>
                <h3>Estudiantes inscritos</h3>
                <ul class="estudiantes">
                        <c:if test="${empty curso.estudiantes}">
                            <li style="list-style: none;">
                                <i>Este curso aún no tiene estudiantes registrados.</i>
                            </li>
                        </c:if>

                        <c:if test="${not empty curso.estudiantes}">
                            <c:forEach var="estudiante" items="${curso.estudiantes}">
                                <li>
                                    <strong>Nombre: ${estudiante.nombre} ${estudiante.apellido}</strong>
                                    <ul>
                                        <li>Edad: <b>${estudiante.edad}</b></li>
                                        <li>Fecha de actualización: <b>${estudiante.fechaActualizacion}</b></li>
                                    </ul>
                                    <br> 
                                </li>
                        </c:forEach>
                        </c:if>
                        
                        
                    </ul>
            </div>
            <p>
                <a href="/cursos/formulario/inscribir/${curso.id}">Inscribir a un nuevo estudiante</a>
            </p>
            <p>
                <a href="/cursos">Volver a cursos</a>
            </p>
        </div>
    </body>
</html>
