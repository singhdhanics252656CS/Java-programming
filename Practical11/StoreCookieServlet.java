package practical11;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/storeCookie")
public class StoreCookieServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");

        Cookie cookie = new Cookie("username", username);

        // Cookie will remain for 1 hour
        cookie.setMaxAge(60 * 60);

        response.addCookie(cookie);

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<body>");
        out.println("<h2>Cookie Stored Successfully!</h2>");
        out.println("<p>Username: " + username + "</p>");
        out.println("<a href='readCookie'>Read Cookie</a>");
        out.println("</body>");
        out.println("</html>");
    }
}
