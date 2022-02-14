<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 1/19/2022
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/login" method="post">
    <label>Username</label>
    <input type="text" name="username" value="${user}">
    <label>Password</label>
    <input type="password" name="password" value="${password}">
    <button type="submit">Login</button>
</form>
</body>
</html>
