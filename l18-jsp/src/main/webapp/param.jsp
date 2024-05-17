<%--
  Created by IntelliJ IDEA.
  User: teacher
  Date: 17.05.2024
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Name: ${param.name}</p>
<p>Age: ${param.age}</p>
<p>Phone 1: ${paramValues.phone[0]}</p>
<p>Phone 2: ${paramValues.phone[1]}</p>
<p>SessionId 2: ${cookie.JSESSIONID.value}</p>
<p>User-Agent: ${header["User-Agent"]}</p>
<p>Host: ${header.host}</p>

</body>
</html>
