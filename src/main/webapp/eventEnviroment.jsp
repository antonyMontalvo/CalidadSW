<%-- 
    Document   : eventEnviroment
    Created on : 29/09/2019, 07:34:12 PM
    Author     : Usuario
--%>

<%@page language="java" import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/webapp/lib/css/simple-sidebar.css" />
        <title>SIGCE</title>
    </head>
    <body>

        <t:sidebar>
            <jsp:attribute name="content">

                <div class="container">

                    <br>
                    <h2 class="ml-4">Ambientes</h2>

                    <br>

                    <c:forEach var="a" items="ambients">
                        <div class="card flex-row flex-wrap ml-4 mr-4">
                            <div class="card-header border-0">
                                <img src="//placehold.it/200" alt="">
                            </div>
                            <div class="card-block px-2">
                                <h4 class="card-title mt-3 ml-3"><c:out value="${a.getDescription()}"/></h4>
                                <p class="card-text mt-3 ml-3">Descripcion</p>
                            </div>
                            <div class="w-100"></div>
                        </div>
                    </c:forEach>

                    <div class="card flex-row flex-wrap ml-4 mr-4">
                        <div class="card-header border-0">
                            <img src="//placehold.it/200" alt="">
                        </div>
                        <div class="card-block px-2">
                            <h4 class="card-title mt-3 ml-3">Título</h4>
                            <p class="card-text mt-3 ml-3">Descripcion</p>
                        </div>
                        <div class="w-100"></div>
                    </div>

                    <br>

                    <div class="card flex-row flex-wrap ml-4 mr-4">
                        <div class="card-header border-0">
                            <img src="//placehold.it/200" alt="">
                        </div>
                        <div class="card-block px-2">
                            <h4 class="card-title mt-3 ml-3">Titulo</h4>
                            <p class="card-text mt-3 ml-3">Descripcion</p>
                        </div>
                        <div class="w-100"></div>
                    </div>

                </div>
                <br>

            </jsp:attribute>
        </t:sidebar>
    </body>
</html>
