package edu.itstep.jsp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/objects")
public class ObjectsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] users = new String[]{"Tom", "Bob", "Mark"};
        req.setAttribute("users", users);
        getServletContext().getRequestDispatcher("/objects.jsp").forward(req, resp);
    }
}
