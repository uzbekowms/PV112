<%--
  Created by IntelliJ IDEA.
  User: teacher
  Date: 17.05.2024
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>Name: <%= request.getParameter("name")%></p>
    <p>Age: <%= request.getParameter("age")%></p>
</body>
</html>
