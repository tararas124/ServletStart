<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: taras
  Date: 14.06.2017
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
    <link type="text/css" rel="stylesheet" href="bootstrap/css/bootstrap.css"/>
    <link type="text/css" rel="stylesheet" href="bootstrap/css/bootstrap-theme.css"/>
</head>
<body>
<jsp:include page="mainMenu.jsp"></jsp:include>
<%--<jsp:include page="menu.jsp"></jsp:include>--%>
<br>

<div class="container">

    <h1>Hello <b>${logginedUser.name}</b></h1>

    <h3>Home page</h3>

    <p>This is simple web application.</p>
</div>
</body>
</html>

