package com.pht.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class UserCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
//        ConditionContext   运行环境上下文

        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();//beanFactory 工厂
        ClassLoader loader =context.getClassLoader();//类加载
        Environment environment = context.getEnvironment();//获取当前环境信息
        BeanDefinitionRegistry registry = context.getRegistry();//获取当前的注册类

        String property = environment.getProperty("os.name");//操作系统
        System.out.println(property);
        if(property.contains("Windows")){
            System.out.println("windows");
            return true;
        }
        return false;
    }
}
