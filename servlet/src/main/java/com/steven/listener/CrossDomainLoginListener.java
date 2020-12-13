package com.steven.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.ArrayList;

/**
 * @author CXQ
 * @version 1.0
 *
 */
@WebListener
public class CrossDomainLoginListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        servletContextEvent.getServletContext().setAttribute("onlineUsers", new ArrayList<>());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        servletContextEvent.getServletContext().getAttribute("onlineUsers");
    }
}