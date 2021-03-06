package com.steven.start.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * @author CXQ
 * @version 1.0
 */
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 因为请求头中允许接收html类型[Accept:text/html...]
        // 所以我可以放心的设置内容的MIME类型为text/html
        resp.setContentType("text/html;charset=utf-8");

        // 利用IO流从服务端向页面端进行传输[响应]
        PrintWriter writer = resp.getWriter();
        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<meta charset=\"UTF-8\">");
        writer.println("<title>servlet-test</title>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("系统时间:" + new Date());
        writer.println("</body>");
        writer.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
