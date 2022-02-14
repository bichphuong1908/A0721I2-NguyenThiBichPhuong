<%--
  Created by IntelliJ IDEA.
  User: BichPhuong
  Date: 2/7/2022
  Time: 3:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title> List</title>
</head>
<body>
<center>
    <h1> List</h1>
    <h2>
        <a href="/chothue/add.jsp">Add</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="7">
        <caption><h2>List</h2></caption>
        <tr>
            <th>Id</th>
            <th>Dien tich</th>
            <th>TrangThai</th>
            <th>Tang</th>
            <th>Loai văn phong</th>
            <th>Gia cho thue</th>
            <th>Ngay bat dau</th>
            <th>Ngay ket thuc</th>
            <th>Actions</th>
        </tr>
        <c:forEach items="${chothue}" var="c">
            <tr>
                <td><c:out value="${c.id}"/></td>
                <td><c:out value="${c.dien_tich}"/></td>
                <td><c:out value="${c.trang_thai}"/></td>
                <td><c:out value="${c.tang}"/></td>
                <td><c:out value="${c.loai_van_phong}"/></td>
                <td><c:out value="${c.gia_cho_thue}"/></td>
                <td><c:out value="${c.ngay_bat_dau}"/></td>
                <td><c:out value="${c.ngay_ket_thuc}"/></td>
                <td>
                    <a href="/chothue?action=delete&id=${c.id}">Xoa</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
