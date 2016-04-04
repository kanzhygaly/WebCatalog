<%-- 
    Document   : product
    Created on : Mar 31, 2016, 7:58:51 PM
    Author     : YERLAN
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product</title>
        <link href="<c:url value='/static/css/bootstrap.min.css' />" rel="stylesheet"></link>
    </head>

    <body>
        <div class="container">
            <div class="well lead">Product Form</div>

            <!-- Main component for a primary marketing message or call to action -->
            <div class="jumbotron">
                <form:form method="POST" modelAttribute="product" class="form-horizontal">
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
                            <form:input type="text" path="description" id="description" class="form-control input-sm" />
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

                    <c:choose>
                        <c:when test="${edit}">
                            <div class="form-group col-md-12">
                                <label class="col-md-3 control-lable" for="dateCreate">Create date</label>
                                <div class="col-md-7">
                                    <form:input type="text" path="dateCreate" id="dateCreate" class="form-control input-sm" disabled="true" />
                                </div>
                            </div>
                        </c:when>
                    </c:choose>

                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="image">Image</label>
                        <div class="col-md-7">
                            <form:input type="image" path="image" id="image" class="form-control input-sm" />
                            <div class="has-error">
                                <form:errors path="image" class="help-inline"/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="category">Category</label>
                        <div class="col-md-7">
                            <form:select path="category" items="${categories}" itemValue="id" itemLabel="type" class="form-control input-sm" />
                            <div class="has-error">
                                <form:errors path="category" class="help-inline"/>
                            </div>
                        </div>
                    </div>

                    <div class="form-actions floatRight">
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
        </div>
    </body>
</html>
