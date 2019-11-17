<%-- 
    Document   : view1
    Created on : 29/09/2019, 01:02:30 AM
    Author     : Usuario
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
                <c:choose>
                    <c:when test="${message != null}">
                        ${message}
                    </c:when>
                    <c:otherwise>
                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${errorMsg != null}">
                        ${errorMsg}
                    </c:when>
                    <c:otherwise>
                    </c:otherwise>
                </c:choose>

                <div class="row">
                    <div class="col-8">

                        <!--Card event creation-->
                        <div class="card ml-4">
                            <div class="card-body">
                                <h2>Crear Evento</h2>
                                Después de crear un evento, no podrás cambiar la configuración de este.

                                <form method="post" action="events_create?action=create1">

                                    <div class="form-group">
                                        <br>
                                        <label class="font-weight-bold" for="title">Título</label>
                                        <input type="text" class="form-control" id="title" name="title" required
                                            placeholder="Docker conference">
                                        <small id="titleHelp" class="form-text text-muted">Agrega un nombre conciso y
                                            claro.</small>
                                    </div>

                                    <div class="form-group">
                                        <br>
                                        <label class="font-weight-bold" for="description">Descripción</label>
                                        <textarea class="form-control" id="description" name="description" required
                                            rows="5"></textarea>
                                        <small id="descriptionHelp" class="form-text text-muted">Cuenta a los demás de
                                            que trata el evento.</small>
                                    </div>

                                    <div class="form-group">
                                        <br>
                                        <label class="font-weight-bold" for="type_event">Tipos de eventos</label>
                                        <select id="type_event" name="type-event" class="form-control" required>
                                            <option hidden selected disabled value="">Elige...</option>
                                            <c:forEach items="${types}" var="item">
                                                <option value="${item.getIdType()}">${item.getName()} </option>
                                            </c:forEach>
                                        </select>
                                    </div>

                                    <div class="row">
                                        <div class="form-group col-md-6">
                                            <br>
                                            <label class="font-weight-bold" for="date">Fecha de inicio</label>
                                            <input class="form-control" type="date" value="${date_now}" id="date"
                                                name="date" required>
                                            <small id="dateHelp" class="form-text text-muted">Día en la cual iniciará el
                                                desarrollo el evento.</small>
                                        </div>
                                        <div class="form-group col-md-6">
                                            <br>
                                            <label class="font-weight-bold" for="date">Fecha de fin</label>
                                            <input class="form-control" type="date" value="${date_now}" id="date_end"
                                                name="date_end" required>
                                            <small id="dateHelp" class="form-text text-muted">Día en la cual finaliza el
                                                desarrollo del evento.</small>
                                        </div>
                                    </div>

                                    <br>

                                    <button type="submit" class="btn btn-primary">Siguiente</button>

                                </form>
                            </div>
                        </div>
                        <!--Card end-->
                        <br>
                    </div>

                    <div class="col-4">
                        <div class="card bg-light mb-3" style="max-width: 18rem;">
                            <div class="card-header">¿Necesitas ayuda?</div>
                            <div class="card-body">
                                <h5 class="card-title">Sobre la creación de eventos...</h5>
                                <p class="card-text">La creción de los eventos se realiza en 3 partes este será la
                                    primera para describir información básica.</p>
                            </div>
                        </div>
                    </div>

                </div>

            </div>

        </jsp:attribute>
    </t:sidebar>
</body>

</html>