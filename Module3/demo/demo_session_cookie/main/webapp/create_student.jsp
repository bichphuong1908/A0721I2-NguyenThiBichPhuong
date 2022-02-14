<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 12/31/2021
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Create student</h2>
<p style="color: blue">
    Chào mừng, <%=request.getSession().getAttribute("usernameSession")%>
</p>
<p style="color: red">${msg}</p>
<form method="post">
    <p>Id:</p>
    <input type="text" name="id">
    <p>Name:</p>
    <input type="text" name="name">
    <p>Date of birth: </p>
    <input type="date" name="dateOfBirth">
    <p>Gender: </p>
    <input type="text" name="gender">
    <p>Grade: </p>
    <input type="text" name="grade">
    <button type="submit">Create</button>
</form>
</body>
</html>
