package edu.itstep;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet("/cookie-example")
public class CookieExampleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String countOfVisits = Arrays.stream(req.getCookies())
                .filter(cookie -> "countOfVisits".equals(cookie.getName()))
                .map(Cookie::getValue)
                .findFirst().orElse("0");


        Cookie countOfVisitsCookie = new Cookie("countOfVisits", String.valueOf(Integer.parseInt(countOfVisits) + 1));
        countOfVisitsCookie.setMaxAge(60 * 60);

        resp.addCookie(countOfVisitsCookie);
        PrintWriter out = resp.getWriter();
        out.println(countOfVisitsCookie.getValue());

        Cookie[] cookies = req.getCookies();
        out.println("<ol>");
        for (Cookie cookie : cookies) {
            out.println("<li>%s - %s</li>".formatted(cookie.getName(), cookie.getValue()));
        }
        out.println("</ol>");
    }
}
