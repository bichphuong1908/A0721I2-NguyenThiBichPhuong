<%--
  Created by IntelliJ IDEA.
  User: quocgunner
  Date: 1/12/22
  Time: 6:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        h1{
            text-align: center;
            font-size: 50px;
        }
        table{
            width: 100%;
            margin: 10px;
            padding: 10px;
        }
    </style>
</head>
<body>
<h1>Customer List</h1>
<a href="create.jsp">Create Customer</a>
<table>
    <thead>
    <th>Name</th>
    <th>Birdthday</th>
    <th>Address</th>
    <th>Avatar</th>
    </thead>
    <tbody>
    <c:forEach items="${customers1}" var="c">
        <tr>
            <td>${c.name}</td>
            <td>${c.birthday}</td>
            <td>${c.address}</td>
            <td><img src="${c.avatar}"></td>
        </tr>
    </c:forEach>

    </tbody>
</table>
</body>
</html>
