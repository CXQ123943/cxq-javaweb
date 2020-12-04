package com.steven.work.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author CXQ
 * @version 1.0
 */
@WebServlet("/servlet/store")
public class StoreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        final String REQUEST = "request";
        final String SESSION = "session";
        final String APPLICATION = "application";

        String meta = req.getParameter("meta");
        if (REQUEST.equals(meta)) {
            request(req, resp);
        } else if (SESSION.equals(meta)) {
            session(req, resp);
        } else if (APPLICATION.equals(meta)) {
            application(req, resp);
        }
    }

    private void application(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ServletContext application = req.getServletContext();
        application.setAttribute("application-name", "application-value-1");
        application.setAttribute("application-name", "application-value-2");
        System.out.println(application.getAttribute("application-name"));
        System.out.println(application.getAttribute("abc"));
        resp.getWriter().println("application: " + application.getAttribute("application-name"));
    }

    private void session(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        System.out.println(session.isNew() ? "session is new..." : "session is old...");
        System.out.println("sessionId: " + session.getId());
        System.out.println("inactiveInterval: " + session.getMaxInactiveInterval());
        session.setMaxInactiveInterval(3600);
        System.out.println("inactiveInterval: " + session.getMaxInactiveInterval());
        session.setAttribute("session-name", "session-value-1");
        session.setAttribute("session-name", "session-value-2");
        System.out.println(session.getAttribute("session-name"));
        System.out.println(session.getAttribute("abc"));
        resp.getWriter().println("session: " + session.getAttribute("session-name"));
    }

    private void request(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setAttribute("request-name", "request-value-1");
        req.setAttribute("request-name", "request-value-2");
        System.out.println(req.getAttribute("request-name"));
        System.out.println(req.getAttribute("abc"));
        resp.getWriter().println("request: " + req.getAttribute("request-name"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
