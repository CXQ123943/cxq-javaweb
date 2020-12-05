package com.steven.work.servlet;

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
@WebServlet("/servlet/ajax")
public class AjaxServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");

        String meta = req.getParameter("meta");
        if (Meta.AJAX_TYPE.equals(meta)) {
            ajaxType(req, resp);
        } else {
            System.out.println("本次请求不是AJAX请求，使用请求转发...");
            req.getRequestDispatcher("/view/main.html").forward(req, resp);
        }
    }

    interface Meta {
        String AJAX_TYPE = "ajax_type";
        String XML_HTTP_REQUEST = "XMLHttpRequest";
    }

    private void ajaxType(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String xRequestedWith = req.getHeader("x-requested-with");
        if (xRequestedWith != null && xRequestedWith.equals(Meta.XML_HTTP_REQUEST)) {
            System.out.println("本次请求是AJAX请求，使用IO回写...");
            resp.setContentType("application/json;charset=UTF-8");
            String jsonStr = "{\"username\":\"admin\",\"password\":\"123\"}";
            resp.getWriter().print(jsonStr);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
