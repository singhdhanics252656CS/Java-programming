<%@ page import="java.sql.*" %>

<html>
<head>
    <title>Display Users</title>
</head>
<body>

<h2>All User Records</h2>

<table border="1" cellpadding="10">

<tr>
    <th>ID</th>
    <th>Username</th>
    <th>Password</th>
    <th>Email</th>
</tr>

<%
    String url = "jdbc:mysql://localhost:3306/userdb";
    String dbUser = "root";
    String dbPassword = "";

    try {

        // MySQL Connector 5.1.10
        Class.forName("com.mysql.jdbc.Driver");

        Connection con = DriverManager.getConnection(
            url, dbUser, dbPassword
        );

        String sql = "SELECT * FROM users";

        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
%>

<tr>
    <td><%= rs.getInt("id") %></td>
    <td><%= rs.getString("username") %></td>
    <td><%= rs.getString("password") %></td>
    <td><%= rs.getString("email") %></td>
</tr>

<%
        }

        rs.close();
        st.close();
        con.close();

    } catch (Exception e) {
%>

<tr>
    <td colspan="4">
        Error: <%= e.getMessage() %>
    </td>
</tr>

<%
    }
%>

</table>

<br>

<a href="index.html">Back to Login</a>

</body>
</html>