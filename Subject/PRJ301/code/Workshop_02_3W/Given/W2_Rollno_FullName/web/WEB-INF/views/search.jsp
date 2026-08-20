<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>MobileInfo - Search</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/app.css">
</head>
<body class="app-bg">
<c:url var="welcomeUrl" value="/MainController">
    <c:param name="action" value="Welcome"/>
</c:url>
<c:url var="mainControllerUrl" value="/MainController"/>
<c:url var="logoutUrl" value="/MainController">
    <c:param name="action" value="Logout"/>
</c:url>

<nav class="navbar navbar-default navbar-static-top">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="${welcomeUrl}">MobileInfo</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li>
                <a href="${welcomeUrl}">
                    <c:out value="${sessionScope.LOGIN_USER.fullName}"/>
                </a>
            </li>
            <li><a href="${logoutUrl}">Logout</a></li>
        </ul>
    </div>
</nav>

<div class="container bottom-space">
    <div class="panel panel-default card-shadow">
        <div class="panel-heading">
            <h3 class="panel-title"><strong>Search by mobile name</strong></h3>
        </div>
        <div class="panel-body">
            <form class="form-inline" action="${mainControllerUrl}" method="get">
                <div class="form-group search-field">
                    <label class="sr-only" for="keyword">Mobile name</label>
                    <input class="form-control" type="text" id="keyword" name="keyword"
                           value="<c:out value='${requestScope.KEYWORD}'/>"
                           placeholder="Enter full or partial mobile name">
                </div>
                <div class="form-group">
                    <label for="sort">Price</label>
                    <select class="form-control" id="sort" name="sort">
                        <c:choose>
                            <c:when test="${requestScope.SORT eq 'DESC'}">
                                <option value="ASC">ASC - Low to High</option>
                                <option value="DESC" selected>DESC - High to Low</option>
                            </c:when>
                            <c:otherwise>
                                <option value="ASC" selected>ASC - Low to High</option>
                                <option value="DESC">DESC - High to Low</option>
                            </c:otherwise>
                        </c:choose>
                    </select>
                </div>
                <button class="btn btn-primary" type="submit" name="action" value="Search">Search</button>
            </form>
        </div>
    </div>

    <c:if test="${not empty requestScope.SEARCH_ERROR}">
        <div class="alert alert-warning card-shadow">
            <c:out value="${requestScope.SEARCH_ERROR}"/>
        </div>
    </c:if>

    <c:if test="${not empty requestScope.MOBILE_LIST}">
        <div class="panel panel-default card-shadow">
            <div class="panel-heading">
                Found <strong><c:out value="${fn:length(requestScope.MOBILE_LIST)}"/></strong> matching mobile(s)
            </div>
            <div class="table-responsive">
                <table class="table table-striped table-hover result-table">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Mobile name</th>
                        <th>Year</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Status</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="mobile" items="${requestScope.MOBILE_LIST}" varStatus="status">
                        <tr>
                            <td><c:out value="${status.count}"/></td>
                            <td><strong><c:out value="${mobile.mobileName}"/></strong></td>
                            <td>
                                <c:choose>
                                    <c:when test="${empty mobile.yearOfProduction}">N/A</c:when>
                                    <c:otherwise><c:out value="${mobile.yearOfProduction}"/></c:otherwise>
                                </c:choose>
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${empty mobile.price}">N/A</c:when>
                                    <c:otherwise>
                                        $<fmt:formatNumber value="${mobile.price}" minFractionDigits="2" maxFractionDigits="2"/>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${empty mobile.quantity}">N/A</c:when>
                                    <c:otherwise><c:out value="${mobile.quantity}"/></c:otherwise>
                                </c:choose>
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${mobile.outOfStock}">
                                        <span class="label label-danger">Out of stock</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span class="label label-success">In stock</span>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </c:if>
</div>
</body>
</html>
