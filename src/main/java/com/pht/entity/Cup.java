package com.pht.entity;

import com.pht.processor.CupProcessor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Cup  implements BeanPostProcessor {
    private String size ;
    private String type;


    public void initMethod(){
        System.out.println("init_Method");
    }
    /**
     * 执行init方法之调用
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public   Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization------");
        return bean;
    }

    /**
     * 执行初始化方法执行进行调用
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public   Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization------------");
        return bean;
    }
    public Cup() {
        System.out.println("contruct");
    }

    @PostConstruct
    public void init(){
        System.out.println("postcontrlle——init");
    }
    @PreDestroy
    public void  destry(){
        System.out.println("postController -destroy");
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
