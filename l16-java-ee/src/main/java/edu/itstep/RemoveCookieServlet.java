package edu.itstep;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/remove-cookie")
public class RemoveCookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // -1
        // 0
        Cookie countOfVisits = new Cookie("countOfVisits", null);
        countOfVisits.setMaxAge(0);
        resp.addCookie(countOfVisits);
    }
}
