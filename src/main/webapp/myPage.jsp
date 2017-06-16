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
    <title>Title</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<br><br>
<h3>HELLO ${user.name}</h3>
<br/>
User Name: <b>${user.name}</b><br/>
User Age: <b>${user.age}</b><br/>
User Address: <b>${user.address}</b><br/><br/><br/>

<table border="1" cellpadding="5" cellspacing="1" >
    <tr>
        <th>Text</th>
        <th>State</th>
        <th>Delete</th>
    </tr>

    <c:forEach items="${itemList}" var="item" >
        <tr>
            <td>${item.text}</td>
            <td>${item.state}</td>
            <td>
                <a methods="post" href="deleteItem?itemId=${item.itemID}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<form action="/createItem" method="post">
    <input type="submit" value="Create Item"/>
</form>
</body>
</html>
