<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>MobileInfo - Welcome</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/app.css">
</head>
<body class="app-bg">
<c:url var="welcomeUrl" value="/MainController">
    <c:param name="action" value="Welcome"/>
</c:url>
<c:url var="searchUrl" value="/MainController">
    <c:param name="action" value="Search"/>
</c:url>
<c:url var="logoutUrl" value="/MainController">
    <c:param name="action" value="Logout"/>
</c:url>

<nav class="navbar navbar-default navbar-static-top">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="${welcomeUrl}">MobileInfo</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="${searchUrl}">Search Mobile</a></li>
            <li><a href="${logoutUrl}">Logout</a></li>
        </ul>
    </div>
</nav>

<div class="container">
    <div class="jumbotron card-shadow">
        <h2>Welcome, <c:out value="${sessionScope.LOGIN_USER.fullName}"/>!</h2>
        <p>You have logged in successfully.</p>
        <hr>
        <div class="row user-info">
            <div class="col-sm-4">
                <strong>Username</strong><br>
                <c:out value="${sessionScope.LOGIN_USER.user}"/>
            </div>
            <div class="col-sm-4">
                <strong>Full name</strong><br>
                <c:out value="${sessionScope.LOGIN_USER.fullName}"/>
            </div>
            <div class="col-sm-4">
                <strong>Role</strong><br>
                <c:out value="${sessionScope.LOGIN_USER.roleName}"/>
            </div>
        </div>
        <p class="top-space">
            <a class="btn btn-primary" href="${searchUrl}">Search Mobile Information</a>
            <a class="btn btn-default" href="${logoutUrl}">Logout</a>
        </p>
    </div>
</div>
</body>
</html>
