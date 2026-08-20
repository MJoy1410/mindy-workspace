<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>MobileInfo - Account Disabled</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/app.css">
</head>
<body class="app-bg">
<c:url var="loginUrl" value="/MainController"/>
<div class="container page-wrap">
    <div class="row">
        <div class="col-sm-6 col-sm-offset-3">
            <div class="panel panel-danger card-shadow">
                <div class="panel-heading"><strong>Account is not active</strong></div>
                <div class="panel-body">
                    <p>
                        The account
                        <strong><c:out value="${requestScope.BLOCKED_USER.user}"/></strong>
                        is currently disabled and cannot use the MobileInfo system.
                    </p>
                    <a class="btn btn-default" href="${loginUrl}">Back to Login</a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
