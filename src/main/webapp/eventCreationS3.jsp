<%-- 
    Document   : eventCreationS3
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

    <script src="https://kit.fontawesome.com/f3fb6f4736.js" crossorigin="anonymous"></script>
    <title>SIGCE</title>
</head>

<body>
    <t:sidebar>
        <jsp:attribute name="content">
            <div class="container-fluid">
                <br>
                <div class="row">
                    <div class="col-7">

                        <a href="./events_create?action=second" class="btn btn-info">
                            <em class="fas fa-chevron-left fa-lg"></em>
                        </a><br>

                        <!--Card event creation-->
                        <div class="card ml-4">
                            <div class="card-body">
                                <h2>Escoge de los horarios que se encuentran disponibles</h2>
                                Para finalizar escogeremos el horario en el cual se realizara el evento.
                                <br><br>

                                <form method="post" action="events_create?action=create3">

                                    <c:forEach items="${events}" var="item" varStatus="i">
                                        <div class="col-auto my-1">
                                            <div class="custom-control custom-checkbox mr-sm-2">
                                                <c:choose>
                                                    <c:when test="${item.getIdEvent() == 1}">
                                                        <input type="checkbox" class="custom-control-input" disabled
                                                            id="customControlAutosizing_${i.count}"
                                                            value="${item.getStartTime()}" name="hour">
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input type="checkbox" class="custom-control-input"
                                                            id="customControlAutosizing_${i.count}"
                                                            value="${item.getStartTime()}" name="hour">
                                                    </c:otherwise>
                                                </c:choose>
                                                <label class="custom-control-label"
                                                    for="customControlAutosizing_${i.count}">
                                                    <c:out value="${item.getStartTime()}" />:00 -
                                                    <c:out value="${item.getEndTime()}" />:00 hrs</label>
                                            </div>
                                        </div>
                                    </c:forEach>

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
                                <p class="card-text">En esta ultima parte se escogera uno de los horarios disponibles
                                    del ambiente que se selecciono, aquellos horarios ocupados no se podran seleccionar.
                                    Los expositores los podra añadir luego.</p>
                            </div>
                        </div>
                    </div>

                </div>

            </div>
        </jsp:attribute>
    </t:sidebar>
</body>

</html>