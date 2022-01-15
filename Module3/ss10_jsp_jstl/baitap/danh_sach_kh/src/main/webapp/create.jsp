<%--
  Created by IntelliJ IDEA.
  User: quocgunner
  Date: 1/12/22
  Time: 7:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/customer?action=create" method="post">
<div>
    Name: <input name="name">
</div>
<div>
    Birthday: <input name="birthday">
</div>
<div>
    Address: <input name="address">
</div>
<div>
    Avatar: <input name="avatar">
</div>
<div>
    <button>Submit</button>
</div>
</form>

</body>
</html>
