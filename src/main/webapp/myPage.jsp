<%--
  Created by IntelliJ IDEA.
  User: taras
  Date: 12.06.2017
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="bootstrap/css/bootstrap.css"/>
    <link type="text/css" rel="stylesheet" href="bootstrap/css/bootstrap-theme.css"/>
    <title>Title</title>
</head>
<body>
<jsp:include page="mainMenu.jsp"></jsp:include>
<br><br>
<div class="container">
    <h2>HELLO <b>${user.name}</b></h2>
    <br/>
    <h4><small>User Name: </small> <b>${user.name}</b></h4><br/>
    <h4><small>User Age: </small> <b>${user.age}</b></h4><br/>
    <h4><small>User Address: </small> <b>${user.address}</b></h4><br/><br/><br/>

    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Text</th>
            <th>State</th>
            <th>Delete</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${itemList}" var="item">
            <tr>
                <td>${item.text}</td>
                <td>${item.state}</td>
                <td>
                    <a methods="post" class="btn btn-default" href="deleteItem?itemId=${item.itemID}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <form action="/createItem" method="post">
        <button type="submit" class="btn btn-danger">Create Item</button>
    </form>
</div>
</body>
</html>
