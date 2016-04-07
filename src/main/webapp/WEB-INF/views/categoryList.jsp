<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Categories</title>
        <link href="<c:url value='/static/css/bootstrap.min.css' />" rel="stylesheet"></link>
        <script type="text/javascript" src="<c:url value='/static/js/app.js' />"></script>
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
                            <li><a href="/products">Products</a></li>
                            <li class="active"><a href="/categories">Categories</a></li>
                        </ul>
                    </div><!--/.nav-collapse -->
                </div><!--/.container-fluid -->
            </nav>

            <div class="panel panel-default">

                <div class="panel-heading">
                    <span class="lead">Categories</span>
                    <span class="lead pull-right"><a href="<c:url value='/categories/add' />" class="glyphicon glyphicon-plus" title="Add new category"></a></span>
                </div>

                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Description</th>
                            <th width="140px"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${categories}" var="category">
                            <tr>
                                <td>${category.name}</td>
                                <td>${category.description}</td>
                                <td class="text-right">
                                    <a href="<c:url value='/categories/edit/${category.id}' />" class="btn btn-success">edit</a>
                                    <a href="<c:url value='/categories/delete/${category.id}' />" class="btn btn-danger" onclick="return confirmDelete()">delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>

            <div class="well">
                <a href="<c:url value='/categories/add' />">New category</a>
            </div>
        </div>
    </body>
</html>
