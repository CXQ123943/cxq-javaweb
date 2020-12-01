package com.steven.start.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author CXQ
 * @version 1.0
 */
@WebServlet(value = "/servlet/init_param_annotation", initParams = {
        @WebInitParam(name = "tel", value = "1314235425"),
        @WebInitParam(name = "email", value = "aa78977@qq.com"),
})
public class InitParamAnnotationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(super.getServletConfig().getInitParameter("tel"));
        System.out.println(super.getServletConfig().getInitParameter("email"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
