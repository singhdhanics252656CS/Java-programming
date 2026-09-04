<%@ page import="java.sql.*" %>

<html>
<head>
    <title>Login Validation</title>
</head>
<body>

<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    String url = "jdbc:mysql://localhost:3306/userdb";
    String dbUser = "root";
    String dbPassword = "";

    try {

        // MySQL Connector 5.1.10
        Class.forName("com.mysql.jdbc.Driver");

        Connection con = DriverManager.getConnection(
            url, dbUser, dbPassword
        );

        String sql = "SELECT * FROM users WHERE username=? AND password=?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, username);
        ps.setString(2, password);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
%>

            <h2>Login Successful!</h2>
            <p>Welcome, <%= username %></p>

<%
        } else {
%>

            <h2>Invalid Username or Password</h2>
            <a href="index.html">Try Again</a>

<%
        }

        rs.close();
        ps.close();
        con.close();

    } catch (Exception e) {
%>

        <h3>Error: <%= e.getMessage() %></h3>

<%
    }
%>

</body>
</html>
