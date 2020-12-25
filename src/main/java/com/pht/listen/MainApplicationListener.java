package com.pht.listen;

import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class MainApplicationListener implements ApplicationListener<ApplicationEvent> {
    /**
     * ContextRefreshedEvent 为容器刷新完成 refresh方法执行完
     * ContextStoppedEvent ：为容器关闭时调用发送事件
     * @param event
     */
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("接受到监听事件："+event.getSource().toString());
    }

}
