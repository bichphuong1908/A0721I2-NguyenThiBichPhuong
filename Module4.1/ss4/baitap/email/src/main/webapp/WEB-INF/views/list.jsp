<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: BichPhuong
  Date: 4/28/2022
  Time: 8:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
</head>
<body>
<h1>list Email</h1>
<a href="/index">Create Setting</a>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Languages</th>
        <th>Page Size</th>
        <th>Spams</th>
        <th>Signature</th>
    </tr>
    <c:forEach var="setting" items="${settingList}">
        <tr>
            <td>${setting.id}</td>
            <td>${setting.languages}</td>
            <td>${setting.page}</td>
            <td>${setting.spams}</td>
            <td>${setting.signature}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
