<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:out value="${greetings}" default="None"/>
<c:remove var="greetings"/>
<c:out value="${greetings}" default="None"/>
<c:catch var="catchException">
    <% int x = 5 / 0;%>
</c:catch>

<c:if test="${catchException != null}">
    <p>Exception: ${catchException}</p>
</c:if>

<ul>
<c:forEach var="i" begin="1" end="10">
    <li>Item <c:out value="${i}"/></li>
</c:forEach>
</ul>
</body>
</html>
