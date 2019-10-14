<%-- 
    Document   : eventCreationS2
    Created on : 29/09/2019, 04:04:12 PM
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

    <title>SIGCE</title>
</head>

<body>
    <t:sidebar>
        <jsp:attribute name="content">
            <div class="container-fluid">
                <br>
                <div class="row">
                    <div class="col-7">

                        <!--Card event creation-->
                        <div class="card ml-4">
                            <div class="card-body">
                                <h2>Escoge tu ambiente</h2>
                                Después de crear un evento, debes escoger el ambiente en el cuál se llevará a cabo.
                                
                                <form method="post" action="events_create?action=create2">

                                    <div class="form-group">
                                        <br>
                                        <label for="environment">Ambiente</label>
                                        <select id="environment" name="environment" class="form-control" required>
                                            <option hidden selected disabled>Elige...</option>
                                            <c:forEach items="${ambients}" var="item">
                                                <option value="${item.getIdAmbient()}">
                                                    <c:out value="${item.getName()}" />
                                                </option>
                                            </c:forEach>
                                        </select>
                                        <small id="enviromentHelp" class="form-text text-muted">Lugar donde se realizará
                                            el evento.</small>
                                    </div>

                                    <br>

                                    <button type="submit" class="btn btn-primary">Siguiente</button>

                                </form>
                            </div>
                        </div>
                        <!--Card end-->
                        <br>
                    </div>

                    <div class="col-1">
                        <!--Default space-->
                    </div>

                    <div class="col-4">
                        <div class="card bg-light mb-3" style="max-width: 18rem;">
                            <div class="card-header">¿Necesitas ayuda?</div>
                            <div class="card-body">
                                <h5 class="card-title">Sobre la creación de eventos...</h5>
                                <p class="card-text">En esta segunda parte se añadira los ambientes que se encuentran
                                    disponibles .</p>
                            </div>
                        </div>
                    </div>

                </div>

            </div>
        </jsp:attribute>
    </t:sidebar>
</body>

</html>