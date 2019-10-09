<%@page import="unmsm.edu.pe.calidadsw.dao.model.Ambient"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="shortcut icon" href="favicon.ico"/>
    <title>Reportes</title>
</head>

<body>
    <h1>Lista de reportes</h1>
    <table>
        <tr>
            <td><a href="/practica1">Ir al menú</a> </td>
        </tr>
    </table>

    <table border="1">
        <thead>
            <tr>
                <td>Filial</td>
                <td>Horas</td>
                <td>Mes</td>
                <td>Año</td>
            </tr>
        </thead>
        <tbody>
            <%
                    List<Ambient> ambients = (List<Ambient>) request.getAttribute("ambients");

                    for (Ambient a : ambients) {
                        out.println("<tr>");
                        out.println("<td>" + a.getDescription() + "</td>");
                        out.println("<td>" + a.getFloor() + "</td>");
                        out.println("<td>" + a.getName() + "</td>");
                        out.println("<td>" + a.getType() + "</td>");
                        out.println("</tr>");
                    }
                %>
        </tbody>
    </table>
</body>

</html>