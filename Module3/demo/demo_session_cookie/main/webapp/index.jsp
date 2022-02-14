<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 12/27/2021
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<%--  C1:--%>
<%--  <form method="get" action="/sum_servlet">--%>

<%--C2: --%>
<%--  <form method="get" action="/result.jsp">--%>

<%--C3: --%>
<form method="post" action="/sum_servlet">
    <p>Num 1: </p>
    <input type="text" name="numberOne">
    <p>Num 2: </p>
    <input type="text" name="numberTwo">
    <button type="submit">Add</button>
</form>
</body>
</html>
