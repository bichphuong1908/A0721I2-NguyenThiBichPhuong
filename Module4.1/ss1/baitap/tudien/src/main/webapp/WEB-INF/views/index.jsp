<%--
  Created by IntelliJ IDEA.
  User: BichPhuong
  Date: 4/22/2022
  Time: 8:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1></h1>
  <h1>Dictionary information</h1>
  <form method="post" action="/index">
      <table>
        <tr>
          <td>English word:</td>
          <td><input type="text" name="word" id="word"></td>
        </tr>
        <tr>
          <td><input type="submit" value="dictionary"></td>
        </tr>
      </table>
  </form>
  <tr>
    <td>Word English:</td>
    <td>${word}</td>
  </tr><br>
  <tr>
    <td>Word Vietnam:</td>
    <td>${wordVN}</td>
  </tr>
  </body>
</html>
