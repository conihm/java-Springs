
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Contador de Visitas</title>
    <style>
        body { font-family: sans-serif; text-align: center; margin-top: 50px; }
        .contador { font-size: 3em; color: blue; font-weight: bold; }
        button { padding: 10px 20px; font-size: 1.2em; cursor: pointer; }
    </style>
</head>
<body>

    <h1>Eres el visitante número:</h1>
    
    <div class="contador">
        <c:out value="${numDeVisitas}" />
    </div>
    
    <br><br>
    
    <form action="/agregarVisita" method="POST">
        <button type="submit">Agregar Visita (+1)</button>
    </form>

</body>
</html>