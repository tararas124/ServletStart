<%--
  Created by IntelliJ IDEA.
  User: taras
  Date: 13.06.2017
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<br><br>
<form method="post" action="/doRegistr">
    Login:<br>
    <input type="text" name="name">
    <br>
    Age:<br>
    <input type="text" name="age">
    <br>
    Address:<br>
    <input type="text" name="address">
    <br>
    Password:<br>
    <input type="text" name="password">
    <br><br>
    <input type="submit" value="Submit">
    <br><br>

    <p>${ errorString }</p>

</form>
</body>
</html>
