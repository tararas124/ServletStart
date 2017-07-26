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
    <link type="text/css" rel="stylesheet" href="bootstrap/css/bootstrap.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link type="text/css" rel="stylesheet" href="bootstrap/css/bootstrap-theme.css"/>
    <script src="bootstrap/js/bootstrap.js"></script>
    <script src="js/mainJS.js"></script>
    <script>
            $(document).ready(function () {
                $("#helpForget").click(function () {
                    $("#myMenu").modal();
                });
            });
    </script>

    <title>Login</title>
</head>
<body>
<jsp:include page="mainMenu.jsp"></jsp:include>
<br><br>
<div class="container">
    <form action="/doLogin" autocomplete="off" name="form" onsubmit="return validateLogin()" method="post"
          class="form-horizontal">
        <div class="form-group">
            <label for="login" class="col-sm-2 control-label">Login</label>
            <div class="col-sm-10">
                <input type="text" name="login" value="${user.name}" class="form-control input-xs" id="login" required
                       placeholder="Enter login">
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
            <div class="col-sm-0">
            <button type="submit" class="btn btn-success">Sign in</button>
            </div>
            <div class="col-sm-4">
            <a id="helpForget" style="cursor: default;">Forget password?</a>
            </div>
        </div>
        <div class="col-sm-offset-2 col-sm-10">
            <h3 style="color: #3e8f3e">${message}</h3>
            <h3 style="color: #3e8f3e">${errorString}</h3>
        </div>
    </form>
</div>

<div class="modal fade" id="myMenu" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-body" style="padding:40px 50px;">
                <form action="/forget" autocomplete="off" onsubmit="return validateMenu()" name="menuForm" method="post" role="form">
                    <div class="form-group">
                        <label for="usrname"><span class="glyphicon glyphicon-user"></span> Username</label>
                        <input type="text" name="login" class="form-control" id="usrname" required placeholder="Enter login">
                    </div>
                    <div class="form-group">
                        <label for="age"><span class="glyphicon"></span> Age</label>
                        <input type="text" name="age" class="form-control" id="age" required placeholder="Enter age">
                    </div>
                    <div class="form-group">
                        <label for="address"><span class="glyphicon"></span> Address</label>
                        <input type="text" name="address" class="form-control" required id="address" placeholder="Enter address">
                    </div>
                    <button type="submit" class="btn btn-success btn-block"><span class="glyphicon glyphicon-off"></span> Submit</button>
                </form>
            </div>
        </div>

    </div>
</div>
</body>
</html>
