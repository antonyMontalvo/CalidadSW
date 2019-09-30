<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="unmsm.edu.pe.practica1.dao.model.Reporte"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
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
                List<Reporte> reportes = (ArrayList<Reporte>) request.getAttribute("reporte");
                
                for (Reporte e: reportes) {
                    out.println("<tr>");
                    out.println("<td>" + e.getNombreFilial() + "</td>");
                    out.println("<td>" + e.getHorasTrabajadas() + "</td>");
                    out.println("<td>" + e.getMes() + "</td>");
                    out.println("<td>" + e.getAnho() + "</td>");
                    out.println("</tr>");
                }
            %>
        </tbody>
    </table>
</body>
</html>