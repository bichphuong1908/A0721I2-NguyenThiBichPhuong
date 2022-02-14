<%--
  Created by IntelliJ IDEA.
  User: BichPhuong
  Date: 2/11/2022
  Time: 7:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mượn Sách</title>
</head>
<body>
<center>
<h1>Mượn Sách</h1>
<form action="/thuvien?action=save" method="post">
    Tên sách:  <input name="tensach" value="${thuvien.tensach}"><br><br>
    Tác giả:  <input name="tacgia" value="${thuvien.tacgia}"><br> <br>
    Tên học sinh: <input style="width: 170px" name="tenhocsinh" value="${thuvien.tenhocsinh}"><br> <br>
    Ngày mượn sách:
    <input type="date" name="bday" max="2021-12-31"><br><br>
    Ngày trả sách:
    <input type="date" name="bday" min="2000-01-02"><br><br>
    <button type="submit">Mượn sách</button>
    <button type="submit">Hủy</button>
</form>
</center>
</body>
</html>

