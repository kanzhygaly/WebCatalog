<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                        <a class="navbar-brand" href="#">Web Catalog</a>
                    </div>
                    <div id="navbar" class="navbar-collapse collapse">
                        <ul class="nav navbar-nav">
                            <li class="active"><a href="/products">Products</a></li>
                            <li><a href="/categories">Categories</a></li>
                        </ul>
                    </div><!--/.nav-collapse -->
                </div><!--/.container-fluid -->
            </nav>

            <div class="panel panel-default">

                <div class="panel-heading">
                    <span class="lead">Products</span>
                    <span class="lead pull-right"><a href="<c:url value='/products/add' />" class="glyphicon glyphicon-plus" title="Add new product"></a></span>
                </div>

                <form:form method="GET" modelAttribute="searchWrapper" action="/products/search">
                    <label for="category">Filter</label>
                    <form:select path="category" id="category" class="form-control input-sm" onchange="this.form.submit()">
                        <form:option value="" label="Select category" />
                        <form:options items="${categories}" itemValue="id" itemLabel="name" />              
                    </form:select>
                </form:form>

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
                            <th width="140px"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${products}" var="product">
                            <tr>
                                <td>${product.name}</td>
                                <td>${product.description}</td>
                                <td>${product.producer}</td>
                                <td>${product.price}</td>
                                <td><fmt:formatDate pattern="mm-dd-yyyy HH:mm" value="${product.dateCreate}" /></td>
                                <td><img src="data:image/jpeg;base64,${product.getEncodedImage()}" class="img-rounded" /></td>
                                <td>${product.category}</td>
                                <td>
                                    <a href="<c:url value='/products/edit/${product.id}' />" class="btn btn-success">edit</a>
                                    <a href="<c:url value='/products/delete/${product.id}' />" class="btn btn-danger">delete</a>
                                </td>
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
