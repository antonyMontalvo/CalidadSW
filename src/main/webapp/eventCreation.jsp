<%-- 
    Document   : view1
    Created on : 29/09/2019, 01:02:30 AM
    Author     : Usuario
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
                                <h2>Crear Evento</h2>
                                Después de crear un evento, no podrás cambiar la configuración de este.

                                <form method="post" action="events_create?action=create1">

                                    <div class="form-group">
                                        <br>
                                        <label class="font-weight-bold" for="title">Título</label>
                                        <input type="text" class="form-control" id="title" name="title" required>
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
                                        <label class="font-weight-bold" for="date">Fecha del evento</label>
                                        <input class="form-control" type="date" value="2019-10-16" id="date" name="date"
                                            required>
                                        <small id="dateHelp" class="form-text text-muted">Día en la cual se desarrollará
                                            el evento, el horario se definira más adelante.</small>
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