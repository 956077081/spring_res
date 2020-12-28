package com.pht.container;

import com.pht.entity.UserInterface;

import javax.servlet.*;
import javax.servlet.annotation.HandlesTypes;
import java.util.EnumSet;
import java.util.Set;

/**
 * HandlesTypes 获取相关连得类  即：向下继承 抽象的类 UserService 和UserAbstrat
 */
@HandlesTypes({UserInterface.class})
public class MyContainerIniation implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
            System.out.println("UserInterface  接口关联的类");
            set.forEach( aClass -> {
                System.out.println(aClass.getSimpleName());
            });
        ServletRegistration.Dynamic dynamic = servletContext.addServlet("hello", UserServlet.class);
        dynamic.addMapping("/user");//添加servlet的 请求路径
        servletContext.addListener(UserListern.class);//添加监听器
        FilterRegistration.Dynamic myfilter = servletContext.addFilter("myfilter", UserFilter.class);//添加路由校验
        myfilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST),true,"/*");
    }
}
