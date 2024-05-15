package edu.itstep.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/session-example")
public class SessionExampleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO: get session
//        HttpSession session = req.getSession();
//
//        Optional<Integer> countOfVisits = Optional.ofNullable((Integer) session.getAttribute("countOfVisits"));
//        session.setAttribute("countOfVisits", countOfVisits.orElse(0) + 1);
////        session.removeAttribute("countOfVisits");
//        resp.getWriter().println("Count of visits: " + countOfVisits);
//
        HttpSession session = req.getSession();
        String name = req.getParameter("name");
        if (name != null)
            session.setAttribute("name", name);
    }
}
