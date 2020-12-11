package com.steven.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author CXQ
 * @version 1.0
 */
@WebFilter("/api/*")
public class IllegalRequestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("IllegalLoginFilter init()...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String uri = req.getRequestURI();
        String effectivePath = "/api/login";
        if (uri.contains(effectivePath) || isLoggedIn(req, resp)) {
            filterChain.doFilter(req, resp);
        } else {
            String ajaxRequestKey = "x-requested-with";
            String ajaxRequestVal = "XMLHttpRequest";
            if (ajaxRequestKey.equals(req.getHeader(ajaxRequestVal))) {
                resp.getWriter().println("{\"message\":\"非法登陆！\"}");
            } else {
                req.getRequestDispatcher("/error.html").forward(req, resp);
            }
        }
    }

    private boolean isLoggedIn(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session;
        synchronized (session = req.getSession()) {
            return session.getAttribute("name") != null;
        }
    }

    @Override
    public void destroy() {
        System.out.println("IllegalLoginFilter destroy()...");
    }
}
