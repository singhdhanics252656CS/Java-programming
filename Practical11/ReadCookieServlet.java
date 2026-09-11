package practical11;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/readCookie")
public class ReadCookieServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        Cookie[] cookies = request.getCookies();

        String username = null;

        if (cookies != null) {
            for (Cookie cookie : cookies) {

                if (cookie.getName().equals("username")) {
                    username = cookie.getValue();
                    break;
                }
            }
        }

        out.println("<html>");
        out.println("<body>");

        if (username != null) {
            out.println("<h2>Cookie Value</h2>");
            out.println("<p>Username: " + username + "</p>");
        } else {
            out.println("<h2>Cookie not found!</h2>");
        }

        out.println("</body>");
        out.println("</html>");
    }
}

