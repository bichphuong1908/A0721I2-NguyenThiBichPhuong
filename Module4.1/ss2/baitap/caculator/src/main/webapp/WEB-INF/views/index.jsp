<%--
  Created by IntelliJ IDEA.
  User: BichPhuong
  Date: 4/24/2022
  Time: 11:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Caculator</title>
  </head>
  <body>
  <h1>Caculator</h1>
  <form action="calculator" method="post">
    <input type="text" name="number1" value="${number1}">
    <input type="text" name="number2" value="${number2}">
    <br><br>
    <input type="submit" name="calculator" value="Addition(+)">
    <input type="submit" name="calculator" value="Subtraction(-)">
    <input type="submit" name="calculator" value="Multiplication(X)">
    <input type="submit" name="calculator" value="Division(/)">
  </form>
  <h2>  Reesult ${calculator} : ${result}</h2>
  </body>
</html>
