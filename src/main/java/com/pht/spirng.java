package com.pht;

import com.pht.config.AopConfig;
import com.pht.config.AutoWiredConfig;
import com.pht.config.DataSourceConfig;
import com.pht.config.InnerAwareConfig;
import com.pht.dao.UserDao;
import com.pht.entity.User;
import com.pht.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class spirng {

    public static void main(String[] args) {

    }
    @Test
    public void autoWiredTest(){
        ApplicationContext applicationContext= new AnnotationConfigApplicationContext(AutoWiredConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        System.out.println(applicationContext.getBean(UserService.class));
        for (String beanDefinitionName  :beanDefinitionNames){
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
        bean.setLabel("1111");
        bean.getLabel();
    }
}
