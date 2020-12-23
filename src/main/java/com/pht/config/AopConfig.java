package com.pht.config;


import com.pht.aop.UserAop;
import com.pht.dao.UserDao;
import com.pht.processor.CupProcessor;
import com.pht.service.UserService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy //开启 切面
/**
 *  *   @Import(AspectJAutoProxyRegistrar.class)
 * EnableAspectJAutoProxy注解 注入了 AspectJAutoProxyRegistrar
 */

/**
 * BeanPostprocessor 是拦截bean的创建 初始化
 * BeanFacory默认使用的是 AbstractBeanFactory
 * ApplicationContext 默认为AbstractApplication
 * spring初始化流程:
 * 1 注册  register(注册bean)
 * 2 刷新参数 refresh（）
 *           prepareBeanFactory（）准备阶段 加载一些aware等组件等
 *           postProcessBeanFactory() 创建beanFactory的 beanpostProcessor 加载一些配置数据（需要自己实现）
 *           invokeBeanFactoryPostProcessors()执行beanFactory的postProcessor
 *           registerBeanPostProcessors()注册 beanpostProCessor
 *           finishBeanFactoryInitialization 完成bean注册 将beanpostprocessor添加到beanFactory中
 *                  preInstantiateSingletons（注册的bean需要满足if (!bd.isAbstract() && bd.isSingleton() && !bd.isLazyInit()) ）-》resolveBeforeInstantiation（）能否返回一个代理对象 不能需要创建
 *                  -》AbstractBeanFactory.getSingleton()-getObject()》AbstractAutowireCapableBeanFactory->createBean()->
 *                  重点：populateBean() 给bean的属性赋值
 *                      applyBeanPostProcessorsBeforeInitialization（） 后置处理器 的 bean初始化之前调用
 *                      invokeInitMethods（）调用bean的初始化方法
 *                      applyBeanPostProcessorsAfterInitialization（） bean的后置处理器bean初始化之后的调用
 *                      invokeAwareInterfaces()和 invokeAwareMethods () bean中注入aware组件
 *
 * bean的创建
 * 一级：bean创建之前 根据InstantiationAwareBeanPostProcessor（AspectJAutoProxyRegistrar 用的就是此postProcessor）   postProcessAfterInitialization 对象判断是否是否返回对象
 *  如果前置能返回对象 postProcessBeforeInitialization 再次返回可以不用调用bean的 后置处理器 直接返回对象
 * 二级：调用beanPostProcessor创建
 *
 **/
@Configuration
public class AopConfig {

    @Bean( name = "userDto")
    public UserDao getUserDto(){
        return  new UserDao();
    }
    @Bean(name = "userAOP")
    public UserAop getUserAop(){
        return new UserAop();
    }
}

