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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://dl.dropbox.com/s/k4yx251xu3v0qxj/simple-sidebar.css" />
    <link rel="icon" href="favicon.ico">
    
    <title>SIGCE</title>
</head>

<body>

    <t:sidebar>
        <jsp:attribute name="content">

            <div class="container">

                <br>
                <h2 class="ml-4">Ambientes</h2>

                <br>

                <c:forEach items="${ambientes}" var="item">
                    <div class="card flex-row flex-wrap ml-4 mr-4">
                        <div class="card-header border-0">
                            <img src="//placehold.it/200" alt="">
                        </div>
                        <div class="card-block px-2">
                            <h4 class="card-title mt-3 ml-3">
                                <c:out value="${item.getName()}" />
                            </h4>
                            <p class="card-text mt-3 ml-3">
                                <c:out value="${item.getDescription()}" />
                            </p>
                        </div>
                        <div class="w-100"></div>
                    </div>
                    <br>
                </c:forEach>

            </div>
            <br>

        </jsp:attribute>
    </t:sidebar>
</body>

</html>