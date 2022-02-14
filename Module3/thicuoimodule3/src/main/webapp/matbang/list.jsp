<%--
  Created by IntelliJ IDEA.
  User: BichPhuong
  Date: 2/7/2022
  Time: 10:38 AM
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
        <a href="/matbang/create.jsp">Add</a>
    </h2>
    <%--    <form method="get" action="/mat_bang">--%>
    <%--        <input type="hidden" name="action" value="search">--%>
    <%--        <label> Loai Van Phong</label><br>--%>
    <%--        <input type="text" name="loai_van_phong">--%>
    <%--        <label> Gia tien</label><br>--%>
    <%--        <input type="text" name="gia_tien">--%>
    <%--        <label> Tang</label>--%>
    <%--        <input type="text" name="tang"><br>--%>
    <%--        <button type="submit">Search</button>--%>
    <%--    </form>--%>
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
        <c:forEach items="${matbangs}" var="m">
            <tr>
                <td><c:out value="${ma.id}"/></td>
                <td><c:out value="${m.dien_tich}"/></td>
                <td><c:out value="${m.trang_thai}"/></td>
                <td><c:out value="${m.tang}"/></td>
                <td><c:out value="${m.loai_van_phong}"/></td>
                <td><c:out value="${m.gia_cho_thue}"/></td>
                <td><c:out value="${m.ngay_bat_dau}"/></td>
                <td><c:out value="${m.ngay_ket_thuc}"/></td>
                <td>
                    <a href="/matbang?action=delete&id=${m.id}">Xoa</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>