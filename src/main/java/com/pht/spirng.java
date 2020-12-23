package com.pht;

import com.pht.config.AutoWiredConfig;
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
}
