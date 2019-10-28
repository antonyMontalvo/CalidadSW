<%-- 
    Document   : eventExhibitor
    Created on : 16/10/2019, 09:41:44 AM
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
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous">
        </script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous">
        </script>
    <link rel="stylesheet" href="https://dl.dropbox.com/s/k4yx251xu3v0qxj/simple-sidebar.css" />
    <link rel="icon" href="https://dl.dropbox.com/s/2eb4fvhjukzew07/favicon.ico">

    <title>SIGCE</title>
</head>

<body>
    <t:sidebar>
        <jsp:attribute name="content">
            <div class="container">
                <br>
                <br>

                <h2 class="ml-4">Expositores</h2>
                <br>

                <form method="post" action="EventExpositorServlet" class="ml-4 mr-4">

                    <div class="form-row align-items-center">


                        <div class="col-8">
                            <label for="events">Eventos disponibles</label>
                            <select id="events" name="eventId" class="form-control mb-2">
                                <option hidden selected disabled>Elige...</option>
                                <c:forEach items="${events}" var="item">
                                    <option value="${item.getIdEvent()}">
                                        <c:out value="${item.getTitle()}" />
                                    </option>
                                </c:forEach>
                            </select>
                        </div>


                        <div class="col-4">
                            <button type="submit" class="btn btn-primary mt-4">Buscar</button>
                        </div>

                    </div>
                </form>
                <br>

                <div class="row ml-4 mr-4">

                    <table class="table">
                        <thead class="thead-dark">
                            <tr>
                                <th scope="col" class="text-center">Nombres</th>
                                <th scope="col" class="text-center">Apellidos</th>
                                <th scope="col" class="text-center">DNI</th>
                                <th scope="col" class="text-center">Especialidad</th>
                                <th scope="col" class="text-center">Nacionalidad</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${exhibitors}" var="item">
                                <tr>
                                    <td class="text-center">${item.getName()}</td>
                                    <td class="text-center">${item.getLastname()}</td>
                                    <td class="text-center">${item.getDni()}</td>
                                    <td class="text-center">${item.getSpecialty()}</td>
                                    <td class="text-center">${item.getNationality()}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>

            </div>
        </jsp:attribute>
    </t:sidebar>
</body>

</html>