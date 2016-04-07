<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product form</title>
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

            <div class="well lead">Product form</div>

            <form:form method="POST" modelAttribute="productWrapper" class="form-horizontal" enctype="multipart/form-data">
                <form:input type="hidden" path="id" id="id"/>

                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="name">Name</label>
                    <div class="col-md-7">
                        <form:input type="text" path="name" id="name" class="form-control input-sm"/>
                        <div class="has-error">
                            <form:errors path="name" class="help-inline"/>
                        </div>
                    </div>
                </div>

                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="description">Description</label>
                    <div class="col-md-7">
                        <form:textarea path="description" id="description" class="form-control input-sm" rows="5" />
                        <div class="has-error">
                            <form:errors path="description" class="help-inline"/>
                        </div>
                    </div>
                </div>

                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="producer">Producer</label>
                    <div class="col-md-7">
                        <form:input type="text" path="producer" id="producer" class="form-control input-sm" />
                        <div class="has-error">
                            <form:errors path="producer" class="help-inline"/>
                        </div>
                    </div>
                </div>

                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="price">Price</label>
                    <div class="col-md-7">
                        <form:input type="text" path="price" id="price" class="form-control input-sm" />
                        <div class="has-error">
                            <form:errors path="price" class="help-inline"/>
                        </div>
                    </div>
                </div>

                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="image" title="In JPEG and PNG formats only">Image</label>
                    <div class="col-md-7">
                        <form:input type="file" path="image" id="image" class="form-control input-sm" />
                        <div class="has-error">
                            <form:errors path="image" class="help-inline"/>
                        </div>
                    </div>
                    <c:if test="${not empty productImage}">
                        <img src="data:image/jpeg;base64,${productImage}" class="img-rounded" />
                    </c:if>
                </div>

                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="category">Category</label>
                    <div class="col-md-7">
                        <form:select path="category" id="category" items="${categories}" itemValue="id" itemLabel="name" class="form-control input-sm" />
                        <div class="has-error">
                            <form:errors path="category" class="help-inline"/>
                        </div>
                    </div>
                </div>

                <div class="form-actions pull-right">
                    <c:choose>
                        <c:when test="${edit}">
                            <input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/products' />">Cancel</a>
                        </c:when>
                        <c:otherwise>
                            <input type="submit" value="Add" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/products' />">Cancel</a>
                        </c:otherwise>
                    </c:choose>
                </div>
            </form:form>
        </div>
    </body>
</html>
