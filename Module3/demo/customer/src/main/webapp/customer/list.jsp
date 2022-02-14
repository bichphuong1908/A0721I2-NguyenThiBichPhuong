<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        table{
            width: 50%;
        }

        td{
            border: 1px solid;
        }
    </style>
</head>
<body>
<center>
<h1>Customer Manager</h1>
<a href="/customer/add.jsp">Create Customer</a>
</center>
<table>
    <thead>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Country</th>
    <th>Action</th>
    </thead>
    <tbody>
    <c:forEach items="${customers}" var="c">
        <tr>
            <td>${c.id}</td>
            <td>${c.name}</td>
            <td>${c.email}</td>
            <td>${c.country}</td>
            <td>
                <a href="/customer?action=edit&id=${c.id}">Edit</a>
                <a href="/customer?action=delete&id=${c.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>

</table>
</body>
</html>
