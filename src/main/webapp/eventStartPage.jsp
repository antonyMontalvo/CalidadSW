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
    <link rel="stylesheet" href="https://dl.dropbox.com/s/k4yx251xu3v0qxj/simple-sidebar.css" />
    <link rel="icon" href="favicon.ico">

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
                    </div>
                </div>



            </div>
        </jsp:attribute>
    </t:sidebar>
</body>

</html>