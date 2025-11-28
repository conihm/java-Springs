<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
	    <meta charset="UTF-8">
        <title>Detalle de los artistas</title>
        <link rel="stylesheet" href="/css/styles.css">
    </head>
    <body>
        <div id="detalle">
            <div>
                <h1>Artista: ${artista.nombre} ${artista.apellido}</h1>
                <p>Biografía: &#160;&#160;<b>${artista.biografia}</b></p> 
                <div>
                    <h3>Canciones compuestas</h3>
                    
                    <ul class="canciones">
                        <c:if test="${empty artista.canciones}">
                            <li style="list-style: none;">
                                <i>Este artista aún no tiene canciones registradas.</i>
                            </li>
                        </c:if>
                        
                        <c:forEach var="cancion" items="${artista.canciones}">
                            <li>
                                <strong>Título: ${cancion.titulo}</strong>
                                <ul>
                                    <li>Álbum: <b>${cancion.album}</b></li>
                                    <li>Género: <b>${cancion.genero}</b></li>
                                    <li>Idioma: <b>${cancion.idioma}</b></li>
                                </ul>
                                <br> 
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
            <p>
                <a href="/artistas">Volver a la lista de artistas</a>
            </p>
        </div>
    </body>
</html>