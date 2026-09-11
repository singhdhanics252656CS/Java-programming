package practical12;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String course = request.getParameter("course");

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

            String sql = "INSERT INTO student(name, email, course) VALUES (?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, course);

            int result = ps.executeUpdate();

            if (result > 0) {

                HttpSession session = request.getSession();

                session.setAttribute("username", name);

                out.println("<html>");
                out.println("<body>");

                out.println("<h2>Registration Successful!</h2>");

                out.println("<p>Name: " + name + "</p>");
                out.println("<p>Email: " + email + "</p>");
                out.println("<p>Course: " + course + "</p>");

                out.println("<br>");

                out.println("<a href='display'>Display All Students</a>");

                out.println("<br><br>");

                out.println("<a href='session.jsp'>Display Session Value</a>");

                out.println("</body>");
                out.println("</html>");
            }

            ps.close();
            con.close();

        } catch (Exception e) {

            out.println("<h2>Error!</h2>");
            out.println("<p>" + e + "</p>");
        }
    }
}
