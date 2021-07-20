package com.pht.entity;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
//构造 -》postContract ->postprocessor->InitializingBean>InitMethod 顺序
public class Cup   {
    private String size ;
    private String type;

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
