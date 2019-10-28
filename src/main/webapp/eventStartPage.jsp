<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page session="true"%>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
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

    <script src="https://kit.fontawesome.com/f3fb6f4736.js" crossorigin="anonymous"></script>
    <title>SIGCE</title>
</head>

<body>

    <t:sidebar>
        <jsp:attribute name="content">
            <br>
            <div class="container ml-4">

                <div class="card mb-3 mr-5">
                    <div class="card-body">
                        <p class="card-text">
                            <h1>Hola, ${sessionScope.username}!</h1>
                        </p>
                        <p class="card-text">Bienvenido al área administrativa de eventos.</p>
                        <p class="card-text">¿Que deseas hacer primero?</p>
                    </div>
                </div>

                <br>
                <div class="container" style="text-align: center;">
                    <p>
                        <a href="./events_create?action=index" class="btn btn-sq-lg btn-light"
                            style="margin-left: 30px;margin-right: 30px;">
                            <em class="fas fa-calendar-plus fa-5x"></em><br />
                            <br>Crear<br>evento
                        </a>
                        <a href="./events?accion=index" class="btn btn-sq-lg btn-light"
                            style="margin-left: 30px;margin-right: 30px;">
                            <em class="fas fa-calendar-alt fa-5x"></em><br />
                            <br>Gestión<br>de eventos
                        </a>
                        <a href="./ambients" class="btn btn-sq-lg btn-light"
                            style="margin-left: 30px;margin-right: 30px;">
                            <em class="fas fa-map-marker-alt fa-5x"></em><br />
                            <br>Ambientes
                        </a>
                        <a href="./EventAttendantServlet" class="btn btn-sq-lg btn-light"
                            style="margin-left: 30px;margin-right: 30px;">
                            <em class="fas fa-users fa-5x"></em><br />
                            <br>Asistentes
                        </a>
                        <a href="./EventExpositorServlet" class="btn btn-sq-lg btn-light"
                            style="margin-left: 30px;margin-right: 30px;">
                            <em class="fas fa-user-graduate fa-5x"></em><br />
                            <br>Expositores
                        </a>
                    </p>
                </div>

            </div>
        </jsp:attribute>
    </t:sidebar>
</body>

</html>