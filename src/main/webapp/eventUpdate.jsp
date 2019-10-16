<%-- 
    Document   : view
    Created on : 29/09/2019, 01:02:30 AM
    Author     : Antony
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html lang="es">

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
            <!--Bloque de contenido, definido en el tag sidebar.tag-->

            <div class="container">
                <br>
                <div class="row">
                    <div class="col-7">

                        <!--Card event creation-->
                        <div class="card bg-light ml-4">
                            <div class="card-body">
                                <h2>Editar Evento</h2>
                                Sólo se podrán editar eran ciertos campos.

                                <form method="post" action="./events_update">

                                    <div class="form-group">
                                        <br>
                                        <label class="font-weight-bold" for="title">Título</label>
                                        <input type="text" class="form-control" id="title" name="title"
                                            value="${eventTitle}" disabled>
                                    </div>

                                    <div class="form-group">
                                        <br>
                                        <label class="font-weight-bold" for="description">Descripción</label>
                                        <textarea class="form-control" id="description" name="description" rows="5"
                                            disabled>${eventDescription}</textarea>
                                    </div>

                                    <div class="form-row">
                                        <div class="form-group col-md-6">
                                            <br>
                                            <label class="font-weight-bold" for="date">Fecha del evento</label>
                                            <input class="form-control" type="date" id="date" name="date"
                                                value="${eventDate}" disabled>
                                        </div>

                                        <div class="form-group col-md-6">
                                            <br>
                                            <label class="font-weight-bold" for="hours">Horario</label>
                                            <input class="form-control" type="text" id="hours" name="hours"
                                                value="${eventStartTime}:00-${eventEndTime}:00 hrs" disabled>
                                        </div>
                                    </div>

                                    <br>
                                    <h3>Se llevará a cabo en:</h3>
                                    <div class="form-row">
                                        <div class="form-group col-md-6">
                                            <br>
                                            <label class="font-weight-bold" for="ambientName">Lugar</label>
                                            <input class="form-control" type="text" id="ambientName" name="ambient-name"
                                                value="${ambientName}" disabled>
                                        </div>

                                        <div class="form-group col-md-6">
                                            <br>
                                            <label class="font-weight-bold" for="ambientCapacity">Aforo</label>
                                            <input class="form-control" type="text" id="ambientCapacity"
                                                name="ambient-capacity" value="${ambientCapacity}" disabled>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <br>
                                        <label class="font-weight-bold" for="ambientDescription">Descripción</label>
                                        <textarea class="form-control" id="ambientDescription"
                                            name="ambient-description" rows="5"
                                            disabled>${ambientDescription}</textarea>
                                    </div>

                                    <br>
                                    <h3>Expositores:</h3>

                                    <c:choose>
                                        <c:when test="${presentations.get(0).getExhibitor().getName() != null}">
                                            <c:forEach items="${presentations}" var="item" varStatus="i">
                                                <div class="form-row">
                                                    <div class="form-group col-md-8">
                                                        <label class="font-weight-bold"
                                                            for="exhibitorName">Expositor</label>
                                                        <input class="form-control" type="text"
                                                            id="exhibitorName_${i.count}" name="exhibitor-name"
                                                            value="${item.getExhibitor().getName()}  ${item.getExhibitor().getLastname()}"
                                                            disabled>
                                                    </div>

                                                    <div class="form-group col-md-4">
                                                        <label class="font-weight-bold" for="schedule">Expositor</label>
                                                        <input class="form-control" type="text" id="schedule_${i.count}"
                                                            name="schedule"
                                                            value="${item.getStartTime()}:00-${item.getEndTime()}:00 hrs"
                                                            disabled>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="font-weight-bold"
                                                        for="presentationTheme_${i.count}">Tema</label>
                                                    <input class="form-control" type="text"
                                                        id="presentationTheme_${i.count}" name="presentation-theme"
                                                        value="${item.getTheme()}" disabled>
                                                </div>
                                            </c:forEach>
                                        </c:when>
                                        <c:otherwise>
                                            <h5>Añadir expositores</h5>
                                            <br>
                                            En proceso
                                            <br>
                                        </c:otherwise>
                                    </c:choose>

                                    <br>
                                    <button type="submit" class="btn btn-primary">Actualizar</button>

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
                                <h5 class="card-title">Sobre la actualización de eventos...</h5>
                                <p class="card-text">En la edición de un evento se pueden añadir a los expositores.</p>
                            </div>
                        </div>
                    </div>

                </div>

            </div>

        </jsp:attribute>
    </t:sidebar>
</body>

</html>