<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>MobileInfo - Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/app.css">
</head>
<body class="app-bg">
<c:url var="mainControllerUrl" value="/MainController"/>
<div class="container page-wrap">
    <div class="row">
        <div class="col-sm-6 col-sm-offset-3 col-md-4 col-md-offset-4">
            <div class="panel panel-default card-shadow">
                <div class="panel-heading text-center">
                    <h3 class="panel-title"><strong>MobileInfo Login</strong></h3>
                </div>
                <div class="panel-body">
                    <c:if test="${not empty requestScope.ERROR}">
                        <div class="alert alert-danger">
                            <c:out value="${requestScope.ERROR}"/>
                        </div>
                    </c:if>

                    <form action="${mainControllerUrl}" method="post" autocomplete="off">
                        <div class="form-group">
                            <label for="username">Username</label>
                            <input class="form-control" id="username" name="username"
                                   value="<c:out value='${requestScope.USERNAME}'/>"
                                   maxlength="35" required autofocus>
                        </div>
                        <div class="form-group">
                            <label for="password">Password</label>
                            <input class="form-control" type="password" id="password"
                                   name="password" maxlength="50" required>
                        </div>
                        <button class="btn btn-primary btn-block" type="submit" name="action" value="Login">
                            Login
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
