package edu.itstep.jsp;

import edu.itstep.jsp.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User("Joe", 45);

        req.setAttribute("user", user);
        getServletContext()
                .getRequestDispatcher("/profile.jsp")
                .forward(req, resp);
    }
}
