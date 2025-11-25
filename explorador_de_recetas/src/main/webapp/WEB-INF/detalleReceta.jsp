<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Detalle Receta</title>
        <link rel = "stylesheet" href = "/css/styles.css">
    </head>
    <body>
        <h1>Detalle Receta</h1>
        
        <c:if test="${not empty mensaje}">
            <p>
                <c:out value="${mensaje}"></c:out>
            </p>
        </c:if>
        
        <c:if test="${empty mensaje}">
            <p>
                Receta: 
                <c:out value="${nombreReceta}" />			
            </p>
            
            <p>
                Ingredientes: 
                <c:out value="${ingredientes}" />			
            </p>
        </c:if>
        
        <a href="/recetas">Volver a la lista de recetas</a>
        
    </body>
</html>