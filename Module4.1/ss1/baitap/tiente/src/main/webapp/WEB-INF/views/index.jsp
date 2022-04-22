<%--
  Created by IntelliJ IDEA.
  User: BichPhuong
  Date: 4/22/2022
  Time: 7:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>Currency Conversion</h1>
  <form method="get" action="/">
      <table>
        <tr>
          <td>USD:</td>
          <td><input name="usd" placeholder="Enter USD" value="0"></td>
        </tr>
        <tr>
          <td>Rate:</td>
          <td><input name="rate" placeholder="Enter rate" value="23000"></td>
        </tr>
        <tr>
          <td></td>
          <td><input type="submit" id="submit" value="Convert"></td>
        </tr>
      </table>
  </form>
  </body>
</html>
