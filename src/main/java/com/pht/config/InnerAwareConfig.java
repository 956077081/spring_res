package com.pht.config;

import com.pht.entity.InnerBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 *  当需要使用spring  底层的实现 时 需要用到 aware接口的实现 利用 applicationContextAware  获取 容器application
 *  原理：使用 bean在注册之前 会使用到BeanPostProcessor 的Beforeinitalition 这是会判断如果Bean 有实现 aware接口  回将 spring底层实例注入
 *  org.springframework.context.support.ApplicationContextAwareProcessor#invokeAwareInterfaces(java.lang.Object)  允许 bean前注入的 spring 底层组件
 *
 */
@Configuration
@PropertySource("classpath:/school.properties")
public class InnerAwareConfig    {
  @Bean
    public InnerBean getInnerBean(){
      return new InnerBean();
  }
}
