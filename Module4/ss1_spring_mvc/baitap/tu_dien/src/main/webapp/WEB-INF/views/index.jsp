<%--
  Created by IntelliJ IDEA.
  User: BichPhuong
  Date: 2/18/2022
  Time: 7:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Từ điển</title>
  </head>
  <body>
  <h1>Dịch tiếng Anh</h1>
  <form method="post", action="/dich.jsp">
    <div>
      <table>
        <tr>
          <td><input type="text" name="search" placeholder="Nhập từ cần dịch" ></td>
          <td><input type="submit" id="submit" value="Dich"></td>
        </tr>
      </table>
    </div>
  </form>
  </body>
</html>
