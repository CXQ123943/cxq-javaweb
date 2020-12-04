package com.steven.work.servlet;

import com.steven.work.service.impl.AccountServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author CXQ
 * @version 1.0
 */
@WebServlet("/account")
public class AccountServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        req.setCharacterEncoding("UTF-8");
        final String LOGIN = "login";

        String meta = req.getParameter("meta");
        if (LOGIN.equals(meta)) {
            login(req, resp);
        }
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        boolean result = new AccountServiceImpl().login(username, password);
        resp.setContentType("text/html;charset=UTF-8");
        // response data
        PrintWriter writer = resp.getWriter();
        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<meta charset=\"UTF-8\">");
        writer.println("<title>xml-servlet</title>");
        writer.println("</head>");
        writer.println("<body>");
        if (result) {
            writer.println("<span>账号：</span>" + username + "<h1>登录成功...</h1>");
        } else {
            writer.println("<h1>登录失败...</h1>");
        }
        writer.println("</body>");
        writer.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        this.doGet(req, resp);
    }
}
