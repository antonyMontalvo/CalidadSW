<%-- 
    Document   : eventAttendant
    Created on : 29/09/2019, 04:58:40 PM
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/webapp/lib/css/simple-sidebar.css" />
        <link rel="icon" href="favicon.ico">        
        <title>SIGCE</title>
    </head>
    <body>
        <t:sidebar>
            <jsp:attribute name="content">
                <div class="container">
                    <br>
                    <br>

                    <h2 class="ml-4">Asistentes</h2>
                    <br>
                    <br>
                    
                    <div class="row ml-4 mr-4">
                        
                        <table class="table">
                            <thead class="thead-dark">
                                <tr>
                                    <th scope="col" class="text-center">ID</th>
                                    <th scope="col" class="text-center">Nombres</th>
                                    <th scope="col" class="text-center">Apellidos</th>
                                    <th scope="col" class="text-center">DNI</th>
                                    <th scope="col" class="text-center">Edad</th>
                                    <th scope="col" class="text-center">Teléfono</th>
                                    <th scope="col" class="text-center">Email</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td class="text-center">1</td>
                                    <td class="text-center">Carol</td>
                                    <td class="text-center">Andia Baltra</td>
                                    <td class="text-center">72468045</td>
                                    <td class="text-center">21</td>
                                    <td class="text-center">3230476</td>
                                    <td class="text-center">carol.andia@unmsm.edu.pe</td>

                                </tr>
                            </tbody>
                        </table>    
                    </div>
                    
                </div>
            </jsp:attribute>
        </t:sidebar>
    </body>
</html>
