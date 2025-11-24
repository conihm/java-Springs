<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>

<!DOCTYPE html>
<html>
    <head>
    </head>
    <body>

        <h1> ¡Hola mundo! </h1>

        <%!
            int i = 0;
            double descuento = 0.1;
            double aplicarDescuento(double precio) {
                return precio * descuento;
        }
        %>

        <ul>
            <% for(int i = 0; i < 10; i++) {%>
                <li><%= i  %></li>
            <% }%>
        </ul>

        <%!
            String nombre = "Constanza";
            String apellido = "Hurtado";
        %>

            <h2> Hola <%= nombre %> <%= apellido %> !</h2>

            <p>
                <c:out value="${mensaje}" />
            </p>

            <c:if test="${numero > 0}" >
                <p>El número es positivo.</p>
            </c:if>

            <ul>
                <c:forEach var = "item" items ="${lista}">
                    <li>${item}</li>
                </c:forEach>
            </ul>


    </body>

</html>