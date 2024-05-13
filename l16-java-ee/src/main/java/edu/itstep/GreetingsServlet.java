package edu.itstep;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/greetings")
public class GreetingsServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("Initialized");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("Name - " + req.getParameter("name"));
//        String[] ids = req.getParameterValues("id");
//
//        for (String id : ids) System.out.println(id);
//
//
//        System.out.println(Thread.currentThread().getName());
//        resp.getWriter().println("Hello");
        String name = req.getParameter("name");
        String lastName = req.getParameter("lastName");

        resp.getWriter().println("GET Name - " + name + " LastName - " + lastName);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String lastName = req.getParameter("lastName");

        resp.getWriter().println("POST Name - " + name + " LastName - " + lastName);
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("Destroy");
    }
}
