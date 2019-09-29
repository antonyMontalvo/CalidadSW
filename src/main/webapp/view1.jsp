<%-- 
    Document   : view1
    Created on : 29/09/2019, 01:02:30 AM
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>SIGCE</title>
    </head>
    <body>

        <!--navBar-->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="#">SIGCE</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <!--<li class="nav-item active">
                        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                    </li>-->
                    <li class="nav-item">
                        <a class="nav-link" href="#">Evento</a>
                    </li>
                    <!--<li class="nav-item">
                        <a class="nav-link" href="#">Pricing</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
                    </li>-->
                </ul>
            </div>
        </nav>
        <!--End navBar-->

        <br>

        <div class="container">

            <div class="row">
                <div class="col-7">

                    <!--Card event creation-->
                    <div class="card">
                        <div class="card-body">
                            <h2>Crear Evento</h2>
                            Después de crear un evento, no podrás cambiar la configuración de este.

                            <form method="post" action="">

                                <div class="form-group">
                                    <br>
                                    <label for="title">Título</label>
                                    <input type="text" class="form-control" id="title" name="title">
                                    <small id="titleHelp" class="form-text text-muted">Agrega un nombre conciso y claro.</small>
                                </div>

                                <div class="form-group">
                                    <br>
                                    <label for="description">Descripción</label>
                                    <textarea class="form-control" id="description" name="description" rows="5"></textarea>
                                    <small id="descriptionHelp" class="form-text text-muted">Cuenta a los demás de que trata el evento.</small>
                                </div>

                                <div class="form-group">
                                    <br>
                                    <label for="environment">Ambiente</label>
                                    <select id="environment" name="environment" class="form-control">
                                        <option selected>Elige...</option>
                                        <option>...</option>
                                    </select>
                                    <small id="enviromentHelp" class="form-text text-muted">Lugar donde se realizará el evento.</small>
                                </div>

                                <div class="form-group">
                                    <br>
                                    <label for="expositor">Expositor</label>
                                    <select id="expositor" name="expositor" class="form-control">
                                        <option selected>Elige...</option>
                                        <option>...</option>
                                    </select>
                                    <small id="expositorHelp" class="form-text text-muted">Persona que presentará la ponencia durante el evento.</small>
                                </div>
                                <br>
                                
                                <button type="submit" class="btn btn-primary">Crear</button>  

                            </form>
                        </div>
                    </div>
                    <!--Card end-->
                </div>

                <div class="col-2">
                    <!--Default space-->
                </div>

                <div class="col-3">
                    <div class="card bg-light mb-3" style="max-width: 18rem;">
                        <div class="card-header">¿Necesitas ayuda?</div>
                        <div class="card-body">
                            <h5 class="card-title">Sobre la creación de eventos...</h5>
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                        </div>
                    </div>
                </div>

            </div>

        </div>

        <br>

    </body>
</html>
