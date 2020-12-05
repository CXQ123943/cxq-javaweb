package com.steven.work.servlet;

import com.steven.work.service.impl.AccountServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
@WebServlet("/servlet/forward")
public class ForwardServlet extends HttpServlet {

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

    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        AccountServiceImpl accountService = new AccountServiceImpl();
        boolean result = accountService.login(username, password);
        resp.setContentType("text/html;charset=UTF-8");
        if (result) {
            // 从请求中得到一个[转发器]，并指定资源路径，资源路径之前建议填写"/"，代表从工程的根出发寻找
            System.out.println("请求转发成功");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/view/main.html");

            // 调用forward方法，告诉[转发器]，让它将请求转发给main.html，并将请求和响应对象交给它
            dispatcher.forward(req, resp);
        } else {
            System.out.println("请求转发失败");
            req.getRequestDispatcher("/view/html/login.html").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        this.doGet(req, resp);
    }
}
