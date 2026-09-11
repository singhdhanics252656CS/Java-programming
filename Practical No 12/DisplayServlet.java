package practical12;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/display")
public class DisplayServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        try {

            // MySQL Connector 5.1.10
            Class.forName("com.mysql.jdbc.Driver");

            // Database connection
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/practical12?characterEncoding=UTF-8",
                    "root",
                    "root"
            );

            String sql = "SELECT * FROM student";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            out.println("<html>");
            out.println("<body>");

            out.println("<h2>All Student Records</h2>");

            out.println("<table border='1' cellpadding='10'>");

            out.println("<tr>");
            out.println("<th>ID</th>");
            out.println("<th>Name</th>");
            out.println("<th>Email</th>");
            out.println("<th>Course</th>");
            out.println("</tr>");

            while (rs.next()) {

                out.println("<tr>");

                out.println("<td>" + rs.getInt("id") + "</td>");
                out.println("<td>" + rs.getString("name") + "</td>");
                out.println("<td>" + rs.getString("email") + "</td>");
                out.println("<td>" + rs.getString("course") + "</td>");

                out.println("</tr>");
            }

            out.println("</table>");

            out.println("<br>");

            out.println("<a href='registration.html'>Register New Student</a>");

            out.println("</body>");
            out.println("</html>");

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {

            out.println("<h2>Error!</h2>");
            out.println("<p>" + e + "</p>");
        }
    }
}

