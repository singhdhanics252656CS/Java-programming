<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Session Value</title>
</head>
<body>

<h2>Session Variable</h2>

<%
    String username = (String) session.getAttribute("username");
%>

<%
    if (username != null) {
%>

    <p>
        Username stored in session:
        <b><%= username %></b>
    </p>

<%
    } else {
%>

    <p>No session variable found.</p>

<%
    }
%>

<br>

<a href="registration.html">Back to Registration</a>

</body>
</html>

