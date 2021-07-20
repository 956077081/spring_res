package com.pht;

import com.pht.config.*;
import com.pht.dao.UserDao;
import com.pht.entity.User;
import com.pht.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Method;

public class spirng {

    public static void main(String[] args) {

    }
    @Test
    public void autoWiredTest(){
        ApplicationContext applicationContext= new AnnotationConfigApplicationContext(AutoWiredConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        System.out.println(applicationContext.getBean(UserService.class));
        for (String beanDefinitionName  : beanDefinitionNames){
            System.out.println(beanDefinitionName);
        }
    }
    @Test
    public void AwareTest(){
        ApplicationContext applicationContext= new AnnotationConfigApplicationContext(InnerAwareConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName  :beanDefinitionNames){
            System.out.println(beanDefinitionName);
        }
    }

    @Test
    public void  ProfileTest(){
//        如果需要选择注册某些bean 不能使用有参构造会刷新参数
//        ApplicationContext applicationContext= new AnnotationConfigApplicationContext(DataSourceConfig.class);
        AnnotationConfigApplicationContext applicationContext =new AnnotationConfigApplicationContext();
            applicationContext.register(DataSourceConfig.class);
            applicationContext.getEnvironment().setActiveProfiles("prod");//激活生产
            applicationContext.refresh();
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName  :beanDefinitionNames){
            System.out.println(beanDefinitionName);
        }
    }
    @Test
    public void  testAop(){
        AnnotationConfigApplicationContext applicationContext =new AnnotationConfigApplicationContext(AopConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        UserDao bean = applicationContext.getBean(UserDao.class);
        /**
         * cglib代理对象 包含了 目标类  以及 增强器（advisor）
         * 调用方法首先会调用 CglibAopProxy 中的intercept的拦截器 拦截方法
         * 在根据 this.advised.getInterceptorsAndDynamicInterceptionAdvice(method, targetClass); 获取增强链
         *  其中会将类的增强器 转换MethodInterceptor然后使用 CglibMethodInvocation.proceed()方法调用拦截器
         *    proceed()方法
         *    proceed()： 会一次调用拦截器的invoke方法 但是拦截器内容有会调用传入的拦截器的invoke方法
         *    顺序：ExposeInvocationInceptor.invoke()-> AspectAfterThrowingAdvice.invoke()->AfterReturningAdviceInterceptor.invoke()->AspectAfterAdvie.invoke
         *    ->MethodBeforeAdviceInceptor.invoke()  直到 所有的拦截器遍历完 再进行返回 执行 methodProxy.invoke(target, argsToUse) 执行的方法
         *    倒序的执行 before -> after->afterreturning|thorwing(如果有异常执行异常通知  没有异常执行返回通知)
         */
        bean.setLabel("1111");
        bean.getLabel();
    }
    @Test
    public void TxTest(){
        AnnotationConfigApplicationContext applicationContext =new AnnotationConfigApplicationContext(TxConfig.class);
        UserService bean = applicationContext.getBean(UserService.class);
        bean.insertUser();
        applicationContext.close();
    }
    @Test
    public void beanFactoryProcessorTest(){
        AnnotationConfigApplicationContext applicationContext =new AnnotationConfigApplicationContext(BeanFactoryConfig.class);
        applicationContext.close();
    }
    @Test
    public void listenerTest(){
        AnnotationConfigApplicationContext applicationContext =new AnnotationConfigApplicationContext(ApplicationListenConfig.class);
        applicationContext.publishEvent(new ApplicationEvent(new String("我发布的事件！")) {
        });
        applicationContext.close();
    }

}
