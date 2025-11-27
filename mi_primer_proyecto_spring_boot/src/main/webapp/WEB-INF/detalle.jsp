<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>



<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Detalle del Videojuego</title>
        <link rel="stylesheet" href="/css/styles.css">
    </head>
    <body>
        <div id="detalle">
            <div>
                <img src="${videojuego.portada}"/>
                <div>
                    <h1>${videojuego.nombre}</h1>
                    <ul>
                        <li>Rating: &#160;&#160;<b>${videojuego.rating}</b> <span>&#9733;</span></li>
                        <li>Fecha Lanzamiento: &#160;&#160;<b>${videojuego.fechaLanzamiento}</b></li>
                        <li>Creador: &#160;&#160;<b>${videojuego.creador.nombre} ${videojuego.creador.apellido}</b></li>
                        <li><p>${videojuego.descripcion}</p></li>
                    </ul>
                </div>
            </div>
            <div>
                <c:if test="${fn:length(videojuegos.resenas) > 0}">
                    <h4>Reseñas</h4>
                        <c:forEach var="resena" items="${videojuegos.resenas}">
                            <li>${resena.mensaje}</li>
		            </c:forEach>
				</c:if>	
            </div>
                <form:form action="/comment" method="POST" modelAttribute="resena">
                    <form:label path="mensaje">Escribe tu reseña </form:label>
                    <form:textarea path="mensaje"></form:textarea>
                    <form:errors path="mensaje"/>
                    <input type= "hidden" name="videojuego" value="${videojuego.id}" />
                    <input type= "submit" value="Enviar" />

                </form:form>
            <div>
            </div>
            <a href="/getAll">Volver</a>
        </div>
    </body>
</html>