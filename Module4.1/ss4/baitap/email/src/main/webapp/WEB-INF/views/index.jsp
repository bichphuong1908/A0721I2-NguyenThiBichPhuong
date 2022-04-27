<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: BichPhuong
  Date: 4/27/2022
  Time: 7:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Email</title>
  </head>
  <body>
  <h1>Settings</h1>
  <form:form method="post" action="${pageContext.request.contextPath}/save" modelAttribute="setting">
    <table>
      <tr>
        <td>ID</td>
        <td><input type="hidden" name="id"></td>
      </tr>
      <tr>
        <td>Languages</td>
        <td><select type="text" name="languages" istems="${languages}">

        </select>
        </td>
      </tr>
      <tr>
        <td>Page Size</td>
        <td><select type="text" name="page" istems="${pages}"></select> email per page</td>
      </tr>
      <tr>
        <td>Spams filter</td>
        <td><input type="text" name="spams"></td>
      </tr>
      <tr>
        <td>Signature</td>
        <td><textarea type="text" name="signature"></textarea></td>
      </tr>
      <tr>
        <td><input type="submit" value="Update"></td>
      </tr>
    </table>
  </form:form>
  </body>
</html>
