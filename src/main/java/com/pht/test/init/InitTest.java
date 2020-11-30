package com.pht.test.init;
// * 在bean contruct执行后之后进行的操作   InitializingBean, DisposableBean以及postControlly和 perDestroy优先级之前 BeanPostProcessor

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * BeanPostProcessor初始化前后执行  构造》BeanPostProcessor 优先级》@postCOntroller 》InitializingBean 》bean的init方法
 * bean销毁时同理
 */
public class InitTest implements InitializingBean, DisposableBean {

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
}
