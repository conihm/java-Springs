<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Detalle de las canciones</title>
        <link rel="stylesheet" href="/css/styles.css">
    </head>
    <body>
        <div id="detalle">
            <div>
                <h1>Título: ${cancion.titulo}</h1>
                    <ul>
                        <li>Artista: &#160;&#160;<b>${cancion.artista}</b></li>
                        <li>Álbum: &#160;&#160;<b>${cancion.album}</b></li>
                        <li>Género: &#160;&#160;<b>${cancion.genero}</b></li>
                        <li>Idioma: &#160;&#160;<b>${cancion.idioma}</b></li>
                        <li>Fecha de creación: &#160;&#160;<b>${cancion.fechaCreacion}</b></li>
                        <li>Última actualización: &#160;&#160;<b>${cancion.fechaActualizacion}</b></li>
                    </ul>
            </div>
            <p>
                <a href="/canciones">Volver</a>
            </p>
              <p>
                <a href="/canciones/formulario/editar/{id}">Editar</a>
            </p>
        </div>
    </body>
</html>