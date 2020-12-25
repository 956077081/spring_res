package com.pht.config;

import com.pht.entity.User;
import com.pht.listen.MainApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

/**
 * spring的事件发布 与接受需要用到ApplicationListener<ApplicationEvent>
 * ApplicationListener 为spring的监听  ApplicationEvent为事件
 *  applicationContext.publishEvent （）发布事件、
 *
 *【发送事件】 applicationContext.publishEvent 发送事件通过
 *   getApplicationEventMulticaster().multicastEvent(applicationEvent, eventType);、
 *      getApplicationEventMulticaster 获取事件多播器（派发器）
 *      multicastEvent 为派发事件
 *          		for (final ApplicationListener<?> listener : getApplicationListeners(event, type)) 获取所有的监听器
 *                  如果	Executor executor = getTaskExecutor(); 如果可以获取 执行器 使用执行器执行否则同步执行
 *                  然后执行 监听的 onApplicationEvent方法
 * 【多播器（派发器）】
 *          refresh:方法中
 *          initApplicationEventMulticaster()初始化多播器
 *              如果没有事件派发器 会创建一个 简单的 SimpleApplicationEventMulticaster（）派发器
 *          registerListeners（）注册监听器
 *              getBeanNamesForType() 获取实现了 ApplicationListener 接口的 监听器 以及getApplicationListeners（spring中的监听器）
 *
 * @EventListener 注解也可以创建监听器方法 详细User 类
 *  EventListener 注解是在  preInstantiateSingletons()中 注册完所有bean以后会再次
 *  再次判断 	if (singletonInstance instanceof SmartInitializingSingleton) {
 *  执行 （EventListenerMethodProcessor）SmartInitializingSingleton .afterSingletonsInstantiated（） -》processBean()->
 *  注入到this.applicationContext.addApplicationListener(applicationListener);    派发器添加了getApplicationListeners() spring中监听器 以及  实现了ApplicationListener接口的监听
 *
 *
 *
 */
@Configuration
@PropertySource({"classpath:/jdbc.properties"})
public class ApplicationListenConfig {
    @Bean
    public MainApplicationListener getlisten(){
        return new MainApplicationListener();
    }

    @Bean
    public User  getUser(){
        System.out.println("注册bean");
        return  new User();
    }
}
