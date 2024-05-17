<%--
  Created by IntelliJ IDEA.
  User: teacher
  Date: 17.05.2024
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" errorPage="error-page.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- <p>${message}</p> --%>
<p><c:out value="${message}"/></p>
<p><c:out value="${param.username}" default="No User"/></p>
<c:forEach var="user" items="${paramValues.users}">
    <p>${user}</p>
</c:forEach>
<ul>
    <c:forEach var="cook" items="${cookie}">
        <li>
            <p><c:out value="${cook.value.name}"/></p>
            <p><c:out value="${cook.value.value}"/></p>
        </li>
    </c:forEach>
</ul>

<c:if test="${param.name eq 'Admin'}">
    Admin panel
</c:if>
<h2>Your choice</h2>
<c:choose>
    <c:when test="${param.choice == 1}">
        <p>You choose first element</p>
    </c:when>
    <c:when test="${param.choice == 2}">
        <p>You choose second element</p>
    </c:when>
    <c:otherwise>
        <p>Undefined</p>
    </c:otherwise>
</c:choose>
<a href="<c:url  value="/profile" />"><c:url value="/profile"/></a>
<c:if test="${param.choice == null}">
    <c:redirect url="/not-found.jsp"/>
</c:if>
<c:if test="${param.exception != null}">
    <%
        System.out.println(5 / 0);
    %>
</c:if>
</body>
</html>
