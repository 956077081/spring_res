package com.pht.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * BeanPostProcessor是使用于所有的bean的
 * 在执行bean的init方法之前会执行 org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory#populateBean(java.lang.String, org.springframework.beans.factory.support.RootBeanDefinition, org.springframework.beans.BeanWrapper)
 * populateBean 的方法该方法 用于  bean的赋值操作
 * 在bean contruct执行后之后进行的操作   InitializingBean, DisposableBean以及postControlly和 perDestroy优先级之前
 */
public class CupProcessor implements BeanPostProcessor {
    @Override
    public   Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor--++++----"+bean+beanName);
        return bean;
    }

    @Override
    public   Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization+++++"+bean+beanName);
        return bean;
    }
}
