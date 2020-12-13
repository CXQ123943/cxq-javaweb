package com.steven.listener;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author CXQ
 * @version 1.0
 */
@WebFilter("/api/cross-domain-login")
public class CrossDomainLoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("CrossDomainLoginFilter: init()...");
    }

    @SuppressWarnings("all")
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String name = req.getParameter("name");
        ServletContext application;
        synchronized (application = req.getServletContext()) {
            List<String> onlineUsers = (List<String>) application.getAttribute("onlineUsers");
            if (onlineUsers.isEmpty() || !onlineUsers.contains(name)) {
                filterChain.doFilter(req, resp);
            } else {
                resp.getWriter().print("{\"message\":\"" + name + "已在别处登录！请先登出\"}");
            }
        }
    }

    @Override
    public void destroy() {
        System.out.println("CrossDomainLoginFilter: destroy()...");
    }
}