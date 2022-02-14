<%--
  Created by IntelliJ IDEA.
  User: BichPhuong
  Date: 2/7/2022
  Time: 3:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Create mặt bằng cho thuê</h1>
<form action="/chothue?action=save" method="post">
    Mã mặt bằng:  <input name="mamatbang" value="${chothue.matbang}"><br><br>
    Trang Thái: <br><select name="trangthai" value="${chothue.trangthai}">
    <option selected>Trống</option>
    <option>Hạ Tầng</option>
    <option>Đầy Đủ</option>
</select><br> <br>
    Tầng: <br> <select style="width: 170px" name="tang" value="${chothue.tang}">
    <option selected>0</option>
    <option>1</option>
    <option>2</option>
    <option>3</option>
    <option>4</option>
    <option>5</option>
    <option>6</option>
    <option>7</option>
    <option>8</option>
    <option>9</option>
    <option>10</option>
    <option>11</option>
    <option>12</option>
    <option>13</option>
    <option>14</option>
    <option>15</option>
</select><br> <br>
    Loại văn phòng: <br> <select style="width: 170px" name="tang" value="${chothue.loaivanphong}">
    <option selected>Cho thuê</option>
    <option>Văn phòng chia sẻ</option>
    <option>Văn phòng trọn gói</option>
</select><br> <br>
    Mô tả chi tiết: <br><textarea type="text" name="description" value="${chothue.motachitiet}" cols="21" rows="10" ></textarea><br><br>
    Ngày bắt đầu:<br>
    <input type="date" name="bday" max="2021-12-31"><br><br>
    Ngày kết thúc:<br>
    <input type="date" name="bday" min="2000-01-02"><br><br>
    <button type="submit">Lưu</button>
    <button type="submit">Hủy</button>
</form>
</body>
</html>

</body>
</html>

