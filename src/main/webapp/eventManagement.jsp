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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webapp/lib/css/simple-sidebar.css" />
    <link rel="icon" href="favicon.ico">
    <title>SIGCE</title>
</head>

<body>

    <t:sidebar>
        <jsp:attribute name="content">
            <div class="container">
                <br>
                <br>

                <h2 class="ml-4">Lista de eventos</h2>
                <br>

                <form method="post" action="EventManagementServlet" class="ml-4 mr-4">

                    <div class="form-row align-items-center">

                        <div class="col-4">
                            <label for="startDate">Fecha inicio</label>
                            <input class="form-control mb-2" type="date" name="start_date" value="2011-08-19"
                                id="startDate">
                        </div>

                        <div class="col-4">
                            <label for="endDate">Fecha fin</label>
                            <input class="form-control mb-2" type="date" name="end_date" value="2011-08-19"
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

                    <table class="table">
                        <thead class="thead-dark">
                            <tr>
                                <th scope="col" class="text-center">ID</th>
                                <th scope="col" class="text-center">Título</th>
                                <th scope="col" class="text-center">Descripción</th>
                                <th scope="col" class="text-center">Fecha</th>
                                <th scope="col" class="text-center">Status</th>
                                <th scope="col" class="text-center">Ambiente</th>
                                <th scope="col" class="text-center">Expositor</th>
                                <th scope="col" class="text-center">Opciones</th>
                            </tr>
                        </thead>
                        <tbody>

                            <c:forEach items="${eventos}" var="item">
                                <tr>
                                    <td class="text-center">
                                        <c:out value="${item.getIdEvent()}" />
                                    </td>
                                    <td class="text-center">
                                        <c:out value="${item.getTitle()}" />
                                    </td>
                                    <td class="text-center">
                                        <c:out value="${item.getDescription()}" />
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
                                        <a class="btn btn-info" href="eventAttendant.jsp">Info</a>
                                        <a class="btn btn-warning" href="#">Editar</a>
                                        <a class="btn btn-dark"
                                            href="EventManagementServlet?accion=publicar&id=${item.getIdEvent()}">Publicar</a>
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