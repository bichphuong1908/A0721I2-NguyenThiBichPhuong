<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: BichPhuong
  Date: 4/27/2022
  Time: 7:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
  <head>
    <title>Email</title>
  </head>
  <body>
  <h1>Settings</h1>
  <a href="${pageContext.request.contextPath}/">Back to list</a>
  <form:form method="post" action="${pageContext.request.contextPath}/save" modelAttribute="setting">
    <table>
      <tr>
        <td>ID</td>
        <td><form:input path="id"></form:input></td>
      </tr>
      <tr>
        <td>Languages</td>
        <td><form:select items="${languages}" path="languages"></form:select>
        </td>
      </tr>
      <tr>
        <td>Page Size</td>
        <td><form:select type="text" items="${pages}" path="page"></form:select> email per page</td>
      </tr>
      <tr>
        <td>Spams filter</td>
        <td><form:input type="text" path="spams"></form:input></></td>
      </tr>
      <tr>
        <td>Signature</td>
        <td><form:textarea type="text"  path="signature"></form:textarea></td>
      </tr>
      <tr>
        <td><input type="submit" value="Update"></td>
      </tr>
    </table>
  </form:form>

  </body>
</html>
