package com.pht.container;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class UserListern implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("servletContext创建！");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("servletContext销毁! ");
    }
}
