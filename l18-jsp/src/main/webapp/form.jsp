<%--
  Created by IntelliJ IDEA.
  User: teacher
  Date: 17.05.2024
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="result-form.jsp">
    Name: <input type="text" name="name">
    Age: <input type="number" name="age">
    <button type="submit">Send</button>
    <%
        response.getWriter().println("Hello from response");

    %>
    <!--
        request -> HttpServletRequest
        session -> HttpSession
        application -> ServletContext
    -->
</form>
</body>
</html>
