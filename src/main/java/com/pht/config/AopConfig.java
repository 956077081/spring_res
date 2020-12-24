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

 * bean的创建
 * 一级：bean创建之前 根据InstantiationAwareBeanPostProcessor（AspectJAutoProxyRegistrar 用的就是此postProcessor）   postProcessAfterInitialization 对象判断是否是否返回对象
 *  如果前置能返回对象 postProcessBeforeInitialization 再次返回可以不用调用bean的 后置处理器 直接返回对象
 * 二级：调用beanPostProcessor创建
 *
 * aspectJ 切面 会调用InstantiationAwareBeanPostProcessor 的后置处理器 创建前和创建后处理postProcessBeforeInitialization
 * 以及postProcessAfterInitialization   最终创建一个代理对象 （如果代理对象有接口则使用jdk的代理 没有使用cglib的代理）
 *
 *总结：AOP加载流程
 * 1 .Aop加载 需要@EnableAspectJAutoProxy 该注解@Import(AspectJAutoProxyRegistrar.class) 引入了AnnotationAwareAspectJAutoProxyCreator 后置处理器
 * 2 .容器的创建流程：
 *      register() 注册组件 ；refresh方法中：registerBeanPostProcessors（）创建了 AnnotationAwareAspectJAutoProxyCreator 后置处理器
 *      finishBeanFactoryInitialization（）完成单实例对象的创建
 *              1. 创建业务组件 以及  切面的组件
 *              2 AnnotationAwareAspectJAutoProxyCreator （该后置处理器 继承自 InstantiationAwareBeanPostProcessor）拦截组件的过程
 *              3 组件创建后判断是否需要增强：如果需要增强 则会包装增强器   给业务对象 返回一个代理对象
 *     当调用增加对象方法时 会调用  CglibAopProxy 中的intercept的拦截器  生成拦截链 即 MethodInterceptor 集合
 *     根据 拦截链依次调用 invoke方法  但是拦截器内容有会调用传入的拦截器的invoke方法
 *            顺序：ExposeInvocationInceptor.invoke()-> AspectAfterThrowingAdvice.invoke()->AfterReturningAdviceInterceptor.invoke()->AspectAfterAdvie.invoke
 *          ->MethodBeforeAdviceInceptor.invoke()  直到 所有的拦截器遍历完 再进行返回 执行 methodProxy.invoke(target, argsToUse) 执行的方法
 *           倒序的执行 before -> after->afterreturning|thorwing(如果有异常执行异常通知  没有异常执行返回通知)
 *
 *
 *
 *
 *
 *
 **/

@EnableAspectJAutoProxy //开启 切面
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

