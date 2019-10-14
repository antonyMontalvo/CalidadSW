<%-- 
    Document   : eventManagement
    Created on : 29/09/2019, 02:09:22 PM
    Author     : Usuario
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://dl.dropbox.com/s/k4yx251xu3v0qxj/simple-sidebar.css" />
    <link rel="icon" href="favicon.ico">

    <script src="https://kit.fontawesome.com/f3fb6f4736.js" crossorigin="anonymous"></script>
    <title>SIGCE</title>
</head>

<body>

    <t:sidebar>
        <jsp:attribute name="content">
            <div class="container">
                <br>
                <c:if test="${message != null}">
                    ${message}
                </c:if>
                <br>

                <h2 class="ml-4">Lista de eventos</h2>
                <br>

                <form method="post" action="EventManagementServlet" class="ml-4 mr-4">

                    <div class="form-row align-items-center">

                        <div class="col-4">
                            <label for="startDate">Fecha inicio</label>
                            <input class="form-control mb-2" type="date" name="start-date" value="2019-10-01"
                                id="startDate">
                        </div>

                        <div class="col-4">
                            <label for="endDate">Fecha fin</label>
                            <input class="form-control mb-2" type="date" name="end-date" value="2019-10-31"
                                id="endDate">
                        </div>

                        <div class="col-4">
                            <button type="submit" value="buscar" name="tipo"
                                class="btn btn-primary mt-4">Buscar</button>
                        </div>

                    </div>
                </form>


                <br>
                <br>

                <div class="row ml-4 mr-4">

                    <table class="table table-hover">
                        <thead class="thead-dark">
                            <tr>
                                <th scope="col" class="text-center">ID</th>
                                <th scope="col" class="text-center">Título</th>
                                <th scope="col" class="text-center">Fecha</th>
                                <th scope="col" class="text-center">Status</th>
                                <th scope="col" class="text-center">Ambiente</th>
                                <th scope="col" class="text-center">Opciones</th>
                            </tr>
                        </thead>
                        <tbody>

                            <c:forEach items="${eventos}" var="item">
                                <tr>
                                    <th scope="row" class="text-center">
                                        <c:out value="${item.getIdEvent()}" />
                                    </th>
                                    <td class="text-center">
                                        <c:out value="${item.getTitle()}" />
                                    </td>
                                    <td class="text-center">
                                        <c:out value="${item.getDate()}" />
                                    </td>
                                    <td class="text-center">
                                        <c:out value="${item.getState()}" />
                                    </td>
                                    <td class="text-center">
                                        <c:out value="${item.getAmbient().getName()}" />
                                    </td>
                                    <td class="text-center">
                                        <a class="btn btn-info" href="./events?accion=update&id=${item.getIdEvent()}">
                                            <em class="fas fa-pen fa-lg"></em>
                                        </a>
                                        <a class="btn btn-warning"
                                            href="./events?accion=delete&id=${item.getIdEvent()}">
                                            <em class="fas fa-trash-alt fa-lg"></em>
                                        </a>
                                        <a class="btn btn-dark" href="./events?accion=publish&id=${item.getIdEvent()}">
                                            <em class="fas fa-eye fa-lg"></em>
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>
                </div>

            </div>
            <br>

        </jsp:attribute>
    </t:sidebar>

</body>

</html>