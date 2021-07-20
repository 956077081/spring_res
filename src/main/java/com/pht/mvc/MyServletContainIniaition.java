package com.pht.mvc;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * AbstractAnnotationConfigDispatcherServletInitializer
 * 创建 前端控制注解方法 添加 子容器 以及父容器
 */
public class MyServletContainIniaition extends AbstractAnnotationConfigDispatcherServletInitializer {
    /**
     * 获取父容器中的配置
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringContainConfig.class};
    }

    /**
     * 获取子容器中的配置
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{
                SpringMvcContainConfig.class
        };
    }

    /**
     * 获取匹配的路由
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
