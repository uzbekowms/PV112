package edu.itstep.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class LogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter initialized");

        String param = filterConfig.getInitParameter("param");
        System.out.println(param);
    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException {
        String remoteAddr = request.getRemoteAddr();

        System.out.println(remoteAddr);

        filterChain.doFilter(request, response);
    }
}
