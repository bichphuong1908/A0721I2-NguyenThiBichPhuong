<%--
  Created by IntelliJ IDEA.
  User: linht
  Date: 4/25/2022
  Time: 6:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create student</title>
</head>
<body>
    <h1>Create new Student</h1>
    <a href="${pageContext.request.contextPath}/student/list">Back to list</a>
    <form method="post" action="${pageContext.request.contextPath}/student/create2">
        <table border="1">
            <tr>
                <td>ID</td>
                <td><input type="text" name="id" /></td>
            </tr>
                <td>Name</td>
                <td><input type="text" name="name" /></td>
            </tr>
                <td><input type="reset" value="Reset" /></td>
                <td><input type="submit" name="Register" /></td>
            </tr>
        </table>
    </form>
</body>
</html>
