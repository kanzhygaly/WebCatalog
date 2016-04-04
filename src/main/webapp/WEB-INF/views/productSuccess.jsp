<%-- 
    Document   : productSuccess
    Created on : Mar 31, 2016, 8:10:12 PM
    Author     : YERLAN
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Operation success</title>
        <link href="<c:url value='/static/css/bootstrap.min.css' />" rel="stylesheet"></link>
    </head>

    <body>
        <div class="container">

            <div class="alert alert-success lead">
                ${success}
            </div>
            <span class="well floatRight">
                Go to <a href="<c:url value='/products' />">Products</a>
            </span>
        </div>
    </body>
</html>
