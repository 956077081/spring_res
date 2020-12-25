package com.pht.config;

import com.pht.entity.User;
import com.pht.processor.BeanDefinationPostProssor;
import com.pht.processor.FactoryBeanPostProcessor;
import org.springframework.context.annotation.*;
import org.springframework.core.PriorityOrdered;

/**
 *FactoryBeanPostProcessor: 是在加载了bean配置但没有实例化之前调用
 * refresh——》
 *          postProcessBeanFactory 找到所有继承了 FactoryBeanPostProcessor的 类
 *          invokeBeanFactoryPostProcessors 执行FactoryBeanPostProcessor的 postProcessBeanFactory 方法
 *   FactoryBeanPostprocessor在所有bean注册之前进行调用
 *
 *  ** bean的加载顺序 需要@@DependsOn 获取  xml中 ref 来配置选择有限加载
 *
 *
 *  BeanDefinationPostProssor: 是在bean配置还没有加载之前进行调用  也是 FactoryBeanPostprocessor 之前调用postProcessBeanDefinitionRegistry
 *   invokeBeanFactoryPostProcessors() 在执行 postProcessor时会有选择  BeanDefinitionRegistryPostProcessor
 *    优先的执行postProcessBeanDefinitionRegistry    源码： invokeBeanDefinitionRegistryPostProcessor()
 *    然后加载 postProcessBeanFactory
 *    执行顺序：BeanDefinitionRegistryPostProcessor 》FactoryBeanPostProcessor
 *          postProcessBeanDefinitionRegistry》postProcessBeanFactory
 *      BeanDefinitionRegistryPostProcessor 可以进行 接口  PriorityOrdered>Order接口进行排序 选择优先级
 *
 */
@Configuration
@Import({FactoryBeanPostProcessor.class, BeanDefinationPostProssor.class})
public class BeanFactoryConfig  {
    @Bean
    public User getUser(){
        System.out.println("注册userBean");
        return new User();
    }


}
