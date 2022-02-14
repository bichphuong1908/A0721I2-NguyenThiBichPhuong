<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 24/01/2022
  Time: 8:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Add new product</h2>
<form action="/product?action=save" method="post">
    <input type="hidden" name="id" value="${product.id}">
    <div>
        Name: <br><input name="name" value="${product.name}">
    </div>
    <div>
        Price: <br><input name="price" value="${product.price}">
    </div>
    <div>
        Quantity: <br><input name="quantity" value="${product.quantity}">
    </div>
    <div>
        Color: <br><input name="color" value="${product.color}">
    </div>
    <div>
        Description: <br><textarea type="text" name="description" value="${product.description}" cols="21" rows="10" ></textarea>
    </div>
    <div>
    Category: <br> <select style="width: 170px" name="categoty" value="${product.category}">
        <option selected>Computer</option>
        <option>Phone</option>
        <option>Table</option>
    </select><br> <br>
    <button>Create</button>
    <button>Back</button>
    </div>
</form>
</body>
</html>


