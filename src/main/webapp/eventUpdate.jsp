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

                                    <input type="text" name="id" value="${idEvent}" hidden>

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
                                            <label class="font-weight-bold" for="date">Fecha de inicio del
                                                evento</label>
                                            <input class="form-control" type="date" id="date" name="date"
                                                value="${eventDate}" disabled>
                                        </div>

                                        <div class="form-group col-md-6">
                                            <br>
                                            <label class="font-weight-bold" for="date_end">Fecha de fin del
                                                evento</label>
                                            <input class="form-control" type="date" id="date_end" name="date-end"
                                                value="${eventDateEnd}" disabled>
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
                                            <c:forEach items="${present.keySet()}" var="date">
                                                <br>
                                                <h5>Presentaciones en la</h5>
                                                <div class="form-group row">
                                                    <label for="presentation_date"
                                                        class="col-sm-2 col-form-label font-weight-bold">Fecha: </label>
                                                    <div class="col-sm-10">
                                                        <input type="date" disabled value="${date}"
                                                            class="form-control text-center font-weight-bold"
                                                            id="presentation_date">
                                                    </div>
                                                </div>
                                                <c:forEach items="${present.get(date)}" var="item" varStatus="i">
                                                    <div class="form-row">
                                                        <div class="form-group col-md-8">
                                                            <label class="font-weight-bold"
                                                                for="exhibitor_name_${i.count}">Expositor</label>
                                                            <input class="form-control" type="text"
                                                                value="${item.getExhibitor().getName()}  ${item.getExhibitor().getLastname()}"
                                                                id="exhibitor_name_${i.count}" disabled
                                                                name="exhibitor-name">
                                                        </div>

                                                        <div class="form-group col-md-4">
                                                            <label class="font-weight-bold"
                                                                for="schedule_${i.count}">Hora</label>
                                                            <input class="form-control" type="text"
                                                                value="${item.getStartTime()}:00 - ${item.getEndTime()}:00 hrs"
                                                                name="schedule" disabled id="schedule_${i.count}">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="font-weight-bold"
                                                            for="presentation_theme_${i.count}">Tema</label>
                                                        <input class="form-control" type="text"
                                                            id="presentation_theme_${i.count}" name="presentation-theme"
                                                            value="${item.getTheme()}" disabled>
                                                    </div>
                                                </c:forEach>
                                            </c:forEach>

                                            <br>
                                            <a href="./events?accion=index"><button type="button"
                                                    class="btn btn-primary">Cancelar</button></a>
                                        </c:when>
                                        <c:otherwise>
                                            <c:forEach items="${present.keySet()}" var="date">
                                                <br>
                                                <h5>Presentaciones en la</h5>
                                                <div class="form-group row">
                                                    <label for="presentation_date"
                                                        class="col-sm-2 col-form-label font-weight-bold">Fecha: </label>
                                                    <div class="col-sm-10">
                                                        <input type="date" readonly value="${date}"
                                                            class="form-control text-center font-weight-bold"
                                                            name="presentation-date" id="presentation_date">
                                                    </div>
                                                </div>
                                                <c:forEach items="${present.get(date)}" var="item" varStatus="i">
                                                    <div class="form-row">
                                                        <div class="form-group col-md-8">
                                                            <label class="font-weight-bold"
                                                                for="exhibitor_name_${i.count}">Expositor</label>
                                                            <select id="exhibitor_name_${i.count}" name="exhibitor-name"
                                                                class="form-control" required>
                                                                <option hidden selected disabled value="">
                                                                    Elige...</option>
                                                                <c:forEach items="${exhibitors}" var="item1">
                                                                    <option value="${item1.getIdExhibitor()}">
                                                                        ${item1.getName()}
                                                                        ${item1.getLastname()} </option>
                                                                </c:forEach>
                                                            </select>
                                                        </div>

                                                        <div class="form-group col-md-4">
                                                            <label class="font-weight-bold"
                                                                for="schedule_${i.count}">Hora</label>
                                                            <input class="form-control" type="text"
                                                                id="schedule_${i.count}" disabled
                                                                value="${item.getStartTime()}:00 - ${item.getEndTime()}:00 hrs">
                                                            <input class="form-control" type="text" required
                                                                name="schedule" hidden value="${item.getStartTime()}">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="font-weight-bold"
                                                            for="presentationTheme_${i.count}">Tema</label>
                                                        <input class="form-control" type="text" required
                                                            placeholder="Ingrese un tema"
                                                            id="presentationTheme_${i.count}" name="presentation-theme">
                                                    </div>
                                                </c:forEach>
                                            </c:forEach>

                                            <br>
                                            <button type="submit" class="btn btn-primary">Añadir expositores</button>
                                            <a href="./events?accion=index"><button type="button"
                                                    class="btn btn-primary">Cancelar</button></a>
                                        </c:otherwise>
                                    </c:choose>

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