<%-- 
    Document   : productsList
    Created on : Mar 31, 2016, 8:09:04 PM
    Author     : YERLAN
--%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Products</title>
        <link href="<c:url value='/static/css/bootstrap.min.css' />" rel="stylesheet"></link>
        <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
    </head>
    <body>
        <div class="generic-container">
            <div class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading"><span class="lead">List of Products</span></div>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Description</th>
                            <th>Producer</th>
                            <th>Price</th>
                            <th>Create date</th>
                            <th>Image</th>
                            <th>Category</th>
                            <th width="100"></th>
                            <th width="100"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${products}" var="product">
                            <tr>
                                <td>${product.name}</td>
                                <td>${product.description}</td>
                                <td>${product.producer}</td>
                                <td>${product.price}</td>
                                <td>${product.dateCreate}</td>
                                <td><img src="<c:url value="${product.image}"/>"/></td>
                                <td>${product.category}</td>
                                <td><a href="<c:url value='/products/edit/${product.id}' />" class="btn btn-success custom-width">edit</a></td>
                                <td><a href="<c:url value='/products/delete/${product.id}' />" class="btn btn-danger custom-width">delete</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="well">
                <a href="<c:url value='/products/add' />">New product</a>
            </div>
        </div>
    </body>
</html>
