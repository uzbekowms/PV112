package edu.itstep.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

@WebServlet("/18n")
public class I18nServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Locale locale = req.getLocale();
        String language = locale.getLanguage();
        String country = locale.getCountry();
        String date = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.SHORT, locale).format(new Date());

        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);

        String formattedCurrency = numberFormat.format(56465413);

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");

        resp.getWriter().println("""
                Locale - %s<br>
                Language - %s<br>
                Country - %s<br>
                Date - %s<br>
                Currency - %s
                """.formatted(locale, language, country, date, formattedCurrency));
    }
}
