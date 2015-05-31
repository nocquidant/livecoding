package live.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/auth/*"})
public class AuthentServlet extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String uri = req.getRequestURI();

    String username = req.getParameter("username");
    String password = req.getParameter("password");

    if ("user".equals(username) && "user1234".equals(password)) {
      resp.getWriter().println("Successful!");
      return;
    }

    resp.getWriter().println("Wrong username or password");
  }
}
