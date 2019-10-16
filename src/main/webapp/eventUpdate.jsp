<%-- 
    Document   : view
    Created on : 29/09/2019, 01:02:30 AM
    Author     : Antony
--%>

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
                        <div class="card ml-4">
                            <div class="card-body">
                                <h2>Editar Evento</h2>
                                Sólo se podrán editar eran ciertos campos.

                                <form method="post" action="./events?accion=index">

                                    <div class="form-group">
                                        <br>
                                        <label for="title">Título</label>
                                        <input type="text" class="form-control" id="title" name="title"
                                            value="${eventTitle}" disabled>
                                    </div>

                                    <div class="form-group">
                                        <br>
                                        <label for="description">Descripción</label>
                                        <textarea class="form-control" id="description" name="description" rows="5"
                                            disabled>${eventDescription}</textarea>
                                    </div>

                                    <div class="form-group">
                                        <br>
                                        <label for="date">Fecha del evento</label>
                                        <input class="form-control" type="date" id="date" name="date"
                                            value="${eventDate}" disabled>
                                    </div>

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