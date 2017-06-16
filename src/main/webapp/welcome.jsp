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
    <link href="${pageContext.request.contextPath}/style/main.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<br>
<div class="try">
<h1>Hello ${logginedUser.name}</h1>
</div>
<h3>Home page</h3>

This is simple web application.
</body>
</html>

