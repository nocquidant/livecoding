package live.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/op/*"})
public class OperationServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    String uri = request.getRequestURI();
    String result = "?";
    if (uri.endsWith("add")) {
      result = doAdd(request, response);
    } else if (uri.endsWith("addToPrevious")) {
      result = doAddToPrevious(request, response);
    }
    response.getWriter().println(result);
  }

  private String doAdd(HttpServletRequest request, HttpServletResponse response) {
    Integer x = Integer.parseInt(request.getParameter("x"));
    Integer y = Integer.parseInt(request.getParameter("y"));
    return "" + (x + y);
  }

  private String doAddToPrevious(HttpServletRequest request, HttpServletResponse response) {
    Integer x = Integer.parseInt(request.getParameter("x"));
    return "Missing the previous result (how could I add " + x + ")";
  }
}
