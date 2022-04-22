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
  <form method="post" action="/index">
        <fieldset>
          <legend>Dictionary information</legend>
          <table>
            <tr>
              <td>English word:</td>
              <td><input type="text" name="word" id="word"></td>
            </tr>
            <tr>
              <td><input type="submit" value="dictionary"></td>
            </tr>
          </table>
        </fieldset>
      </form>
  </form>
  </body>
</html>
