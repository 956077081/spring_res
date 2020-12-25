package com.pht.processor;

import com.pht.entity.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

@Component
public class BeanDefinationPostProssor   implements BeanDefinitionRegistryPostProcessor {
    /**
     * postProcessBeanDefinitionRegistry 的执行是在 postProcessBeanFactory之前进行 即 是在bean加载前进行调用
     * @param registry
     * @throws BeansException
     */
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        RootBeanDefinition  rootBeanDefinition= new RootBeanDefinition();
        rootBeanDefinition.setBeanClass(User.class);
        registry.registerBeanDefinition("user",rootBeanDefinition);//加载bean配置 注册
//      BeanDefinitionBuilder.rootBeanDefinition()
        System.out.println("postProcessBeanDefinitionRegistry");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("postProcessBeanFactory");
    }
}
