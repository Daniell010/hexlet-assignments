package exercise.servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public final class HelloServlet extends HttpServlet {
    // BEGIN
    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        var parameter = request.getParameter("name");
        var name = parameter == null ? "Guest" : parameter;
        response.getWriter().println("Hello, " + name + "!");
    }
    // END
}
