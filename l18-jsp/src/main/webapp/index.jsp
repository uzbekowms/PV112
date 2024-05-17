<%
    String[] people = new String[]{"Tom", "Bob", "Joe", "Doe"};
    String header = "Users list";
%>

<!DOCTYPE html>
<body>
<h2><%=header%></h2>
<h2><%=people%></h2>
<%
    out.println("<ul>");
    for (String person : people) {
        out.println("<li>" + person + "</li>");
    }
    out.println("</ul>");
%>
<p><%=new java.util.Date()%>
</p>

<p>5 + 2 = <%= 5 + 2%>
<p>5 > 2 = <%= 5 > 2%>
</p>
<%
    out.println("<ul>");
    for (int i = 0; i < 10; i++) {
        out.println("<li>" + i + "</li>");
    }
    out.println("</ul>");
%>
<% if (Math.random() > 0.5) {%>
Hello world
<% } else {%>
Not hello
<%} %>
</body>
</html>
<!--
Jsp Expression
Jsp Scriplet
Jsp Declaration
Jsp Directive
Jsp Comments

-->