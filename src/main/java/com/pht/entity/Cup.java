package com.pht.entity;

import com.pht.processor.CupProcessor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Cup  implements BeanPostProcessor {
    private String size ;
    private String type;
    @Override
    public   Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor------"+bean+beanName);
        return bean;
    }

    @Override
    public   Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization"+bean+beanName);
        return bean;
    }
    public Cup() {
        System.out.println("contruct");
    }

    @PostConstruct
    public void init(){
        System.out.println("postcontrlle——init"+this);
    }
    @PreDestroy
    public void  destry(){
        System.out.println("postController -destroy"+this);
    }
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
