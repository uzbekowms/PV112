package edu.itstep;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


public class GreetingsServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("Initialized");
        System.out.println(config.getInitParameter("email"));
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
//        System.out.println(getServletContext().getInitParameter("email"));
//        resp.setContentType("text/html");
//
//        String name = req.getParameter("name");
//        String lastName = req.getParameter("lastName");
//        PrintWriter writer = resp.getWriter();
//
//        writer.println("""
//                <p>Name - %s</p>
//                <p>Last name - %s</p>
//                """.formatted(name, lastName));
//        req.getRequestDispatcher("/students").forward(req, resp);
//        req.getRequestDispatcher("/WEB-INF/secret.html").forward(req, resp);
//        resp.sendRedirect("/notfound.html");
        resp.sendError(500);

        System.out.println(getServletConfig().getInitParameter("email"));
        resp.sendRedirect("/WEB-INF/secret.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String name = req.getParameter("name");
        String lastName = req.getParameter("lastName");

        PrintWriter writer = resp.getWriter();

        writer.println("""
                <p>Name - %s</p>
                <p>Last name - %s</p>
                """.formatted(name, lastName));
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("Destroy");
    }
}
