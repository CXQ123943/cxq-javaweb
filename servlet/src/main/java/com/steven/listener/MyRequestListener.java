package com.steven.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

/**
 * @author CXQ
 * @version 1.0
 */
@WebListener
public class MyRequestListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent event) {
        HttpServletRequest req = (HttpServletRequest) event.getServletRequest();
        System.out.println("request init: " + req.getRequestURI());
    }

    @Override
    public void requestDestroyed(ServletRequestEvent event) {
        HttpServletRequest req = (HttpServletRequest) event.getServletRequest();
        System.out.println("request destroy: " + req.getRequestURI());
    }
}