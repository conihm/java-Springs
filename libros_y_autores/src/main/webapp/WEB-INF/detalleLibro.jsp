<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Detalle libro</title>
    </head>
    <body>
        <h1>Detalle libro</h1>	
        <c:if test="${not empty mensaje}">
            <p>
                <c:out value="${mensaje}"></c:out>
            </p>
        </c:if>
        
        <c:if test="${empty mensaje}">
            <p>
                Nombre libro: 
                <c:out value="${nombre}" />			
            </p>
            
            <p>
                Autor: 
                <c:out value="${autor}" />			
            </p>
        </c:if>
        
        <a href="/libros">Volver a la lista de libros</a>
        
    </body>
</html>