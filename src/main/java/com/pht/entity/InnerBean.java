package com.pht.entity;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.util.StringValueResolver;

/**
 * applicaiotnContextAWARE 获取spring容器 BeanNameAware 获取bean名称 EmbedderValueResoluverAware 数据解析
 */
public class InnerBean  implements ApplicationContextAware , BeanNameAware, EmbeddedValueResolverAware {

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println(applicationContext);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println(name+"Bean名车");
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        String s = stringValueResolver.resolveStringValue("你好啊${school.stuNum}今日赚去#{-100*100}");
        System.out.println(s);
    }
}
