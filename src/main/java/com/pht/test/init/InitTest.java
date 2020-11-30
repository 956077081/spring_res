package com.pht.test.init;
// * 在bean contruct执行后之后进行的操作   InitializingBean, DisposableBean以及postControlly和 perDestroy优先级之前 BeanPostProcessor

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
public class InitTest implements InitializingBean, DisposableBean, BeanPostProcessor {

    public InitTest() {
        System.out.println("InitTest");
    }
    public void init(){
        System.out.println("spring_bean  init");
    }
    @PostConstruct
    public void testPostCo(){
        System.out.println("state_PostConstruct");
    }
    @PreDestroy
    public void testDispost(){
        System.out.println("end_PreDestroy");
    }
    @Override
    public void destroy() throws Exception {
        System.out.println("end_DisposableBean");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("start_InitializingBean");
    }


    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("statrt_BeanPostProcessor");
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("end_BeanPostProcessor");
        return o;
    }
}
