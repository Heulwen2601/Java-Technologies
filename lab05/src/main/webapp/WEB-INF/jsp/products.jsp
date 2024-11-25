<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Products</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>

<%
    String username  = (String)session.getAttribute("username");
%>

<body style="background-color: #f8f8f8">

<div class="container-fluid p-5">
    <div class="row mb-5">
        <div class="col-md-6">
            <h3>Product Management</h3>
        </div>
        <div class="col-md-6 text-right">
            Hello <span class="text-danger">${username}</span> | <form action="Logout" method="post">
            <button type="submit" class="btn btn-link">Logout</button>
        </form>
        </div>
    </div>
    <div class="row rounded border p-3">
        <div class="col-md-4">
            <c:if test="${not empty error}">
                <div class="alert alert-danger" role="alert">
                        ${error}
                </div>
            </c:if>
            <h4 class="text-success">Add new product</h4>
            <form class="mt-3" method="post" action="products">
                <div class="form-group">
                    <label for="product-name">Product name</label>
                    <input class="form-control" type="text" placeholder="Enter product name" id="product-name" name="productname">
                </div>
                <div class="form-group">
                    <label for="price">Product price</label>
                    <input class="form-control" type="number" placeholder="Enter price" id="price" name="productprice">
                </div>
                <div class="form-group">
                    <button class="btn btn-success mr-2" type="submit" value="Submit">Add product</button>
                </div>

<!--                <div class="alert alert-danger">-->
<!--                    Please enter product name-->
<!--                </div>-->
            </form>
        </div>
        <div class="col-md-8">
            <h4 class="text-success">All the products</h4>
            <p>Choose one single product</p>
            <form class="mt-3" action="products" method="post">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                    <c:forEach items="${products}" var="product">
                        <tr>
                            <td><c:out value="${product.id}"/></td>
                            <td><c:out value="${product.name}"/></td>
                            <td>$<c:out value="${product.price}"/></td>
                            <td>
                                    <input type="hidden" name="action" value="delete"/>
                                <button class="btn btn-success mr-2" type="submit" name="deleteProductId" value="${product.id}">Delete</button>

                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            </form>
        </div>
    </div>
</div>
<script>
    // Add the following code if you want the name of the file appear on select
    $(".custom-file-input").on("change", function() {
        var fileName = $(this).val().split("\\").pop();
        $(this).siblings(".custom-file-label").addClass("selected").html(fileName);
    });
</script>
</body>
</html>
