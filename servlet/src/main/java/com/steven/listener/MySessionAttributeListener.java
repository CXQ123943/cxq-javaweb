package com.steven.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * @author CXQ
 * @version 1.0
 */
@WebListener
public class MySessionAttributeListener implements HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("session add: " + event.getName() + "/" + event.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println("session remove: " + event.getName() + "/" + event.getValue());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        // value is old...
        System.out.println("session replace: " + event.getName() + "/" + event.getValue());
    }
}