<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <%= square(5) %>

</head>
<body>
<%
    out.println("<ul>");
    for (int i = 0; i < 10; i++) {
        out.println("<li>" + square(i) + "</li>");
    }
    out.println("</ul>");
%>
<%!
    int square(int n) {
        return n * n;
    }
%>
</body>
</html>
