package practical11;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/readSession")
public class ReadSessionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);

        out.println("<html>");
        out.println("<body>");

        if (session != null) {

            String username =
                    (String) session.getAttribute("username");

            if (username != null) {

                out.println("<h2>Session Value</h2>");
                out.println("<p>Username: "
                            + username + "</p>");

            } else {

                out.println("<p>Username not found in session.</p>");
            }

        } else {

            out.println("<p>No session exists.</p>");
        }

        out.println("</body>");
        out.println("</html>");
    }
}
