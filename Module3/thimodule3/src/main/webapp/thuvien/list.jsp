<%--
  Created by IntelliJ IDEA.
  User: BichPhuong
  Date: 2/11/2022
  Time: 6:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh sách sách</title>
</head>
<body>
<center>
</center>
<div align="center">
    <table border="1" cellpadding="7">
        <caption><h2>Danh Sách Sách</h2></caption>
        <tr>
            <th>Id</th>
            <th>TenSach</th>
            <th>TacGia</th>
            <th>SoLuong</th>
            <th>Mota</th>
            <th></th>
        </tr>
        <c:forEach items="${thuvien}" var="c">
            <tr>
                <td><c:out value="${c.id}"/></td>
                <td><c:out value="${c.ten_sach}"/></td>
                <td><c:out value="${c.tac_gia}"/></td>
                <td><c:out value="${c.so_luong}"/></td>
                <td><c:out value="${c.mo_ta}"/></td>
                <td>
                    <a href="/thuvien/create.jsp=${c.id}">mượn</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
