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
    <link type="text/css" rel="stylesheet" href="bootstrap/css/bootstrap.css"/>
    <link type="text/css" rel="stylesheet" href="bootstrap/css/bootstrap-theme.css"/>
    <script src="js/mainJS.js"></script>
    <title>Create Item</title>
</head>
<body>
<jsp:include page="mainMenu.jsp"></jsp:include>
<br><br>
<form autocomplete="off" method="post" action="/doCreateItem" name="form" onsubmit="return validateItem()"
      class="form-horizontal">
    <div class="form-group">
        <label for="login" class="col-sm-2 control-label">Text</label>
        <div class="col-sm-10">
            <input type="text" name="text" class="form-control input-xs" id="login" required
                   placeholder="Enter text">
        </div>
    </div>

    <div class="form-group">
        <label for="pass" class="col-sm-2 control-label">State</label>
        <div class="col-sm-10">
            <input type="text" name="state" class="form-control input-xs" id="pass" required
                   placeholder="Enter state">
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-2 control-label" for="submit"></label>
        <div class="col-md-10">
            <button name="submit" id="submit" type="submit" class="btn btn-primary" value="1">Submit</button>
            <a href="myPage" name="cancel" class="btn btn-default">Cancel</a>
        </div>
    </div>
</form>
<%--<form method="post" action="/doCreateItem" name="form" onsubmit="return validate()">--%>
    <%--<label>Text:<br><input type="text" name="text" required></label>--%>
    <%--<br>--%>
    <%--<label>State:<br><input type="text" name="state" required></label>--%>
    <%--<br><br>--%>
    <%--<input type="submit" value="Submit">--%>
    <%--<a href="myPage">Cancel</a>--%>
    <br><br>


    <p>${ errorString }</p>

</body>
</html>
