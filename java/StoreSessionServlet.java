package practical11;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/storeSession")
public class StoreSessionServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");

        HttpSession session = request.getSession();

        session.setAttribute("username", username);

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<body>");

        out.println("<h2>Session Created Successfully!</h2>");
        out.println("<p>Username stored in session: "
                    + username + "</p>");

        out.println("<a href='readSession'>Read Session</a>");

        out.println("</body>");
        out.println("</html>");
    }
}
