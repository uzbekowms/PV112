package edu.itstep.jsp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/request-attr")
public class RequestAttrServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("name", "Bob");
        req.setAttribute("age", 54);

        getServletContext()
                .getRequestDispatcher("/request-attr.jsp")
                .forward(req, resp);
    }
}
