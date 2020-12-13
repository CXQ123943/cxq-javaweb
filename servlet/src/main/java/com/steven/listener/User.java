package com.steven.listener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * @author CXQ
 * @version 1.0
 */
public class User implements HttpSessionBindingListener {

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("User join to HttpSession: " + event.getSession().getId());
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("User leave from HttpSession: " + event.getSession().getId());
    }
}
