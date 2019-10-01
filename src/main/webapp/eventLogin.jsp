<%-- 
    Document   : eventLogin
    Created on : 29/09/2019, 08:00:24 PM
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/webapp/lib/css/custom-login.css" />
        <title>SIGCE</title>
    </head>
    <body>
        <br>
        <br>
        <br>
        <br>
        <div class="login-form">
            <form action="" method="post" class="rounded">
                <h2 class="text-center">SIGCE Log in</h2>  
                <hr>
                <br>
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Usuario" required="required">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" placeholder="Contraseña" required="required">
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-block" formaction="eventStartPage.jsp">Acceder</button>
                </div>       
            </form>

        </div>


    </body>
</html>
