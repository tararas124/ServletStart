<%--
  Created by IntelliJ IDEA.
  User: taras
  Date: 17.06.2017
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#"> MySite</a>
            </div>

            <div>
                <ul class="nav navbar-nav">
                    <li><a href="${pageContext.request.contextPath}/welcome">Home</a></li>
                    ${loginedUser == null ? "" : "<li><a href=\"/myPage\">Account Info</a></li>"}
                </ul>

                <ul class="nav navbar-nav navbar-right">
                    ${loginedUser == null ? "<li><a href=\"/regist\"><span class=\"glyphicon glyphicon-user\"></span> Sign Up</a></li>" : ""}
                    ${loginedUser == null ? "<li><a href=\"/login\"><span class=\"glyphicon glyphicon-log-in\"></span> Login</a></li>" : ""}
                    ${loginedUser == null ?  "" : "<li><a href=\"/doSignOut\"><span class=\"glyphicon glyphicon-log-out\"></span> Log out</a></li>"}
                </ul>
            </div>
        </div>
    </nav>
</div>
