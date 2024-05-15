package edu.itstep.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();

        String name = (String) session.getAttribute("name");

        if (name == null) {
            out.println("Hello unknown user!");
        } else {
            out.println("Hello " + name);
        }


        Enumeration<String> attributeNames = session.getAttributeNames();
        while (attributeNames.hasMoreElements())
            out.println(attributeNames.nextElement());
        out.println(session.getId());
        out.println(session.isNew());
    }
}
