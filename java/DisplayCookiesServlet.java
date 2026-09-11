package practical11;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/displayCookies")
public class DisplayCookiesServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        Cookie[] cookies = request.getCookies();

        out.println("<html>");
        out.println("<body>");

        out.println("<h2>Cookies Stored on Client</h2>");

        if (cookies != null) {

            out.println("<table border='1'>");

            out.println("<tr>");
            out.println("<th>Cookie Name</th>");
            out.println("<th>Cookie Value</th>");
            out.println("</tr>");

            for (Cookie cookie : cookies) {

                out.println("<tr>");
                out.println("<td>" + cookie.getName() + "</td>");
                out.println("<td>" + cookie.getValue() + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");

        } else {

            out.println("<p>No cookies found.</p>");

        }

        out.println("</body>");
        out.println("</html>");
    }
}
