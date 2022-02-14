<%--
  Created by IntelliJ IDEA.
  User: quocgunner
  Date: 1/14/22
  Time: 6:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/customer?action=save" method="post">
    <input type="hidden" name="id" value="${customer.id}">
    <div>
        Name: <input name="name" value="${customer.name}">
    </div>
    <div>
        Email: <input name="email" value="${customer.email}">
    </div>
    <div>
        Country: <input name="country" value="${customer.country}">
    </div>
    <button>Submit</button>
</form>
</body>
</html>
