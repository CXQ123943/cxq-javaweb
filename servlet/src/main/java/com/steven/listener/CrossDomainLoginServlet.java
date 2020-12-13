package com.steven.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author CXQ
 * @version 1.0
 */
@WebServlet("/api/cross-domain-login")
public class CrossDomainLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String meta = req.getParameter("meta");
        if (Meta.LOGIN.equals(meta)) {
            login(req, resp);
        }
    }

    interface Meta {
        String LOGIN = "login";
    }

    @SuppressWarnings("all")
    public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //假设登录成功
        String name = req.getParameter("name");
        ServletContext application;
        synchronized (application = req.getServletContext()) {
            List<String> onlineUsers = (List<String>) application.getAttribute("onlineUsers");
            onlineUsers.add(name);
            application.setAttribute("onlineUsers", onlineUsers);
        }
        resp.getWriter().print("{\"message\":\"" + name + "登录了您的网站！\"}");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}