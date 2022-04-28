<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: BichPhuong
  Date: 4/28/2022
  Time: 3:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>List Declaration</title>
  </head>
  <body>
  <h1>list Declaration</h1>
  <a href="/create">Create Declaration</a>
  <table border="1">
    <tr>
      <th>STT</th>
      <th>HỌ và tên</th>
      <th>Năm sinh</th>
      <th>Giới tính</th>
      <th>Quốc TỊch</th>
      <th>CMND</th>
    </tr>
    <c:forEach var="declaration" items="${declarations}">
      <tr>
        <td>${declaration.id}</td>
        <td>${declaration.name}</td>
        <td>${declaration.birthday}</td>
        <td>${declaration.sex}</td>
        <td>${declaration.nationality}</td>
        <td>${declaration.cardId}</td>
      </tr>
    </c:forEach>

  </table>
  </body>
</html>
