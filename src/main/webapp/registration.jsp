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
    <link type="text/css" rel="stylesheet" href="bootstrap/css/bootstrap.css"/>
    <link type="text/css" rel="stylesheet" href="bootstrap/css/bootstrap-theme.css"/>
    <script src="js/mainJS.js"></script>
    <title>Registration</title>
    <link type="text/css" rel="stylesheet" href="style/main.css">
</head>
<body>
<jsp:include page="mainMenu.jsp"></jsp:include>
<br><br>
<div class="container">
    <form action="/doRegistr" autocomplete="off" name="form" method="post" onsubmit="return validateRegist()"
          class="form-horizontal">
        <div class="form-group">
            <label for="login" class="col-sm-2 control-label">Login</label>
            <div class="col-sm-10">
                <input type="text" name="name" class="form-control input-xs" id="login" required
                       placeholder="Enter login">
            </div>
        </div>

        <div class="form-group">
            <label for="age" class="col-sm-2 control-label">Age</label>
            <div class="col-sm-10">
                <input type="text" name="age" class="form-control input-xs" id="age" required placeholder="Enter age">
            </div>
        </div>

        <div class="form-group">
            <label for="address" class="col-sm-2 control-label">Address</label>
            <div class="col-sm-10">
                <input type="text" name="address" class="form-control input-xs" id="address" required
                       placeholder="Enter address">
            </div>
        </div>

        <div class="form-group change">
            <label for="pass" class="col-sm-2 control-label">Password</label>
            <div class="col-sm-10">
                <input type="text" name="password" class="form-control input-xs" id="pass" required
                       placeholder="Enter password">
            </div>
        </div>
        <div class="form-group change">
            <label for="pass2" class="col-sm-2 control-label">Confirm password</label>
            <div class="col-sm-10">
                <input type="text" name="password2" class="form-control input-xs" onblur="checkPasswords()" id="pass2"
                       required
                       placeholder="Confirm password">
            </div>
        </div>
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-success">Submit</button>
        </div>
        <div class="col-sm-offset-2 col-sm-10">
            <h3 style="color: #3e8f3e">${errorString}</h3>
        </div>
    </form>
</div>
<%--<form method="post" action="/doRegistr" name="form" onsubmit="return validate()">--%>
<%--<label>Login:<br><input type="text" name="name" required></label>--%>
<%--<br>--%>
<%--<label>Age:<br><input type="text" name="age" required></label>--%>
<%--<br>--%>
<%--<label>Address:<br><input type="text" name="address" required></label>--%>
<%--<br>--%>
<%--<label>Password:<br><input type="text" name="password" required></label>--%>
<%--<br><br>--%>
<%--<input type="submit" value="Submit">--%>
<%--<br><br>--%>

</form>
</body>
</html>
