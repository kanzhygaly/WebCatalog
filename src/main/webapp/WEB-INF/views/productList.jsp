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
    </head>
    <body>

        <div class="container">
            <!-- Static navbar -->
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="#">Web Catalog</a>
                    </div>
                    <div id="navbar" class="navbar-collapse collapse">
                        <ul class="nav navbar-nav">
                            <li class="active"><a href="#">Products</a></li>
                            <li><a href="#">Categories</a></li>
                        </ul>
                    </div><!--/.nav-collapse -->
                </div><!--/.container-fluid -->
            </nav>

            <div class="panel panel-default">

                <div class="panel-heading">
                    <span class="lead">Products</span>
                </div>
                
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
                                <td><img src="<c:url value="${product.image}"/>" class="img-rounded"/></td>
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
