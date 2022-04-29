<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: BichPhuong
  Date: 4/28/2022
  Time: 3:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Declaration</title>
    <style>
        h1{
            text-align: center;
        }
        h3{
            text-align: center;
        }
        h4{
            color: red;
            text-align: center;
        }
    </style>
</head>
<body>
<h1>KHAI BÁO Y TẾ</h1>
<h3>ĐÂY LÀ TÀI LIỆU QUAN TRONG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LÁC KHI CẦN THIẾT ĐỂ PHONHF CHỐNG DỊCH BÊNH TRUYỀN NHIỄM</h3>
<h4>Khuyến cáo: khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể sử lý hành sự</h4>

<center>
<form:form method="post" action="${pageContext.request.contextPath}/save" modelAttribute="declaration">
    <table>
        <tr>
            <td>STT</td>
            <td>
                <form:input path="id"></form:input>
            </td>
        </tr>
        <tr>
            <td>Ho ten</td>
            <td><form:input path="name"></form:input>
            </td>
        </tr>
        <tr>
            <td>Nam sinh</td>
            <td><form:input type="date" path="birthday"></form:input></td>
        </tr>
        <tr>
            <td>Gioi tinh</td>
            <td><form:radiobuttons path="sex" items="${sexs}"></form:radiobuttons></td>
        </tr>
        <tr>
            <td>Quoc tich</td>
            <td><form:select path="nationality" items="${nationalitys}"></form:select></td>
        </tr>
        <tr>
            <td>CMDN</td>
            <td><form:input path="cardId"></form:input>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="Gửi từ khai"></td>
        </tr>
    </table>
</form:form>
<a href="${pageContext.request.contextPath}/">Back to list</a>
</center>
</body>
</html>
