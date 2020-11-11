package com.pht.entity;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class Computer implements BeanPostProcessor {
    public Computer() {
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(this.getClass().getTypeName()+"postProcessBeforeInitialization"+beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(this.getClass().getTypeName()+"postProcessAfterInitialization"+beanName);
        return bean;
    }
}
