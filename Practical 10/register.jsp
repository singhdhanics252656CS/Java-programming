<%@ page import="java.sql.*" %>

<html>
<head>
    <title>User Registration</title>
</head>
<body>

<h2>User Registration</h2>

<form method="post">

    Username:
    <input type="text" name="username" required>
    <br><br>

    Password:
    <input type="password" name="password" required>
    <br><br>

    Email:
    <input type="email" name="email" required>
    <br><br>

    <input type="submit" value="Register">

</form>

<%
    if ("POST".equalsIgnoreCase(request.getMethod())) {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        String url = "jdbc:mysql://localhost:3306/userdb";
        String dbUser = "root";
        String dbPassword = "";

        try {

            // MySQL Connector 5.1.10
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                url, dbUser, dbPassword
            );

            String sql = "INSERT INTO users(username, password, email) VALUES (?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, email);

            int result = ps.executeUpdate();

            if (result > 0) {
%>

                <h3>Registration Successful!</h3>
                <a href="index.html">Go to Login</a>

<%
            }

            ps.close();
            con.close();

        } catch (Exception e) {
%>

            <h3>Error: <%= e.getMessage() %></h3>

<%
        }
    }
%>

</body>
</html>