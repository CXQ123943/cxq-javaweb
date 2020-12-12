package com.steven.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author CXQ
 * @version 1.0
 */
@WebListener
public class AnnotationListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("AnnotationListener: contextInitialized()...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("AnnotationListener: contextDestroyed()...");
    }
}
