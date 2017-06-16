<%--
  Created by IntelliJ IDEA.
  User: taras
  Date: 14.06.2017
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Item</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<br><br>
<form method="post" action="/doCreateItem">
    Text:<br>
    <input type="text" name="text">
    <br>
    State:<br>
    <input type="text" name="state">
    <br><br>
    <input type="submit" value="Submit">
    <a href="myPage">Cancel</a>
    <br><br>


    <p>${ errorString }</p>

</body>
</html>
