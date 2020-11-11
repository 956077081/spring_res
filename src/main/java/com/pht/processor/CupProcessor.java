package com.pht.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 在bean contruct执行后之后进行的操作   InitializingBean, DisposableBean以及postControlly和 perDestroy优先级之前
 */
public interface CupProcessor extends BeanPostProcessor {
    @Override
    public default  Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor--++++----"+bean+beanName);
        return bean;
    }

    @Override
    public default  Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization+++++"+bean+beanName);
        return bean;
    }
}
