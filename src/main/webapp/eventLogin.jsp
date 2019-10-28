<%-- 
    Document   : eventLogin
    Created on : 29/09/2019, 08:00:24 PM
    Author     : Usuario
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous">
        </script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous">
        </script>
    <link rel="stylesheet" type="text/css" href="https://dl.dropbox.com/s/usb8v6axquvg8u4/custom-login.css" />
    <link rel="icon" href="https://dl.dropbox.com/s/2eb4fvhjukzew07/favicon.ico">

    <title>SIGCE</title>
</head>

<body>
    <br>
    <br>
    <br>
    <br>

    <div class="login-form">

        <form action="login" method="post" class="rounded">

            <c:if test="${e!=null}">
                <div class="alert alert-warning" role="alert">
                    <c:out value="${e}" />
                </div>
            </c:if>

            <h2 class="text-center">SIGCE</h2>
            <hr>
            <br>
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Usuario" name="username" required="required">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" placeholder="Contraseña" name="password"
                    required="required">
            </div>
            <div class="form-group">
                <input type="submit" name="loginBtn" value="Acceder">
            </div>
        </form>

    </div>


</body>

</html>