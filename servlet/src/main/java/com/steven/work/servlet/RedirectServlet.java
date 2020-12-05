package com.steven.work.servlet;

import com.steven.work.service.impl.AccountServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author CXQ
 * @version 1.0
 */
@WebServlet("/servlet/redirect")
public class RedirectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");

        final String LOGIN = "login";

        String meta = req.getParameter("meta");
        if (LOGIN.equals(meta)) {
            login(req, resp);
        }
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        AccountServiceImpl accountService = new AccountServiceImpl();
        boolean result = accountService.login(username, password);
        resp.setContentType("text/html;charset=UTF-8");

        if (result) {
            // 重定向跳到主页面
            System.out.println("重定向成功");
            // resp.sendRedirect(req.getContextPath() + "/view/main.html");
            resp.sendRedirect(req.getContextPath() + "/web-inf-res");
        } else {
            // 重定向跳回登录页面
            System.out.println("重定向失败");
            resp.sendRedirect(req.getContextPath() + "/view/html/login.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
