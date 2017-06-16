<%--
  Created by IntelliJ IDEA.
  User: taras
  Date: 14.06.2017
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<br><br>
<form method="post" action="/doLogin">
Login:<br>
<input type="text" name="login" value="${user.name}">
<br>
Password:<br>
<input type="text" name="password" value="${user.password}">
<br><br>
<input type="submit" value="Submit">
<br><br>
</form>

<p>${errorString}</p>
</body>
</html>
