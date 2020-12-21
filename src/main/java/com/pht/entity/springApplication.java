package com.pht.entity;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class springApplication implements ApplicationContextAware {
    private  static ApplicationContext applicationContext =null;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
            this.applicationContext =applicationContext;
    }
    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }
}
