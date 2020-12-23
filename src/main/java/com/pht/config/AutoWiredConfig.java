package com.pht.config;

import com.pht.dao.UserDao;
import com.pht.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.annotation.Resources;

@Configuration
@ComponentScan({"com.pht.service","com.pht.dao"})

/**
 * @bean 使用  方法参数如果有对象 默认是取 容器中的组件
 * public  User getUser( Car car) car对象取自容器中注册的组件  ****
 */
/**
 * 自动注入 的使用  @AutoWired(required=true)默认 注入为空时报错
 * 1 当 getBean(UserDao.class )扫描多个组件时 会调用 getBean("当前属性名称") 获取组件
 * 例如 组件AutoWiredConfig 中注册useDao2   以及扫描到UserDao 类的组件 userDao
 * 当userService    需要注入  UserDao时  @AutoWird 会更具类型选择如果有多个 在更具userDao的
 * 属性名称选择bean
 *  2  当注册多个bean时    需要注入时 可以利用@Qualifier表是更具bean名称来选择bean
 *  3  当注册多个相同类型的bean时可以 利用@primary来选择哪个优先
 */
/**
 * java带的 注入方式@Resources() resources注入 默认是按 名称注入的  不支持@Premary注解
 *  以及@Inject和@ AutoWired的作用一致 （只是缺少required）
 */
/**
 * @AutoWird 注解是可以到 参数  方法 构造器上（ 不深究）
 */


public class AutoWiredConfig {
    @Bean( name = "useDao2")
//    @Primary
    public UserDao getUserDaop(){
        UserDao userDao = new UserDao();
        userDao.setLabel("2");
        return userDao;
    }
}
