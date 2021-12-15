package com.pht;

import com.pht.config.*;
import com.pht.entity.Computer;
import com.pht.entity.Cup;
import com.pht.entity.Person;
import com.pht.entity.Water;
import com.pht.entity.value.School;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;

import java.util.Scanner;

public class MainTest {
  public static ApplicationContext applicationContext = new AnnotationConfigApplicationContext( ScopeTest.class);
//    public static ApplicationContext applicationContext3 = null;

    public static AnnotationConfigApplicationContext applicationContext3 = new AnnotationConfigApplicationContext(InitMyConfig.class);
    public static void main(String[] args) {
//        scopeTest();

//        AnnoScanBeans();
//        xmlscanBeans();
//        xmlConfigBean();
//        annoConfigBean();

    }
    @Test
    public void initValueTest(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ValueConifg.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (int i = 0; i <beanDefinitionNames.length ; i++) {
            System.out.println(beanDefinitionNames[i]);
        }
        Object bean = applicationContext.getBean(School.class);
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String property = environment.getProperty("school.stuNum");//environment存放的是容器中需要的配置文件信息
        System.out.println(property);
        System.out.println(bean);
    }
    @Test
    public void initWaterTest(){

        Water bean = applicationContext3.getBean(Water.class);
        System.out.println(bean);
    }
    @Test
    public  void initCupTest(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext( InitMyConfig2.class);
//        Computer bean = applicationContext.getBean(Computer.class);
//        System.out.println(bean);
    }
    @Test
    public  void   scopeTest(){
        ApplicationContext applicationContext =MainTest.applicationContext;
        System.out.println(applicationContext.getBean(Person.class)==applicationContext.getBean(Person.class));
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("BEAN|"+beanDefinitionName);
        }
        Object houseBeanfactory = applicationContext.getBean("houseFactoryBean");
        String typeName = houseBeanfactory.getClass().getTypeName();
        System.out.println(typeName);//虽然写时获取的时工厂 bean  但是实际上getbean时 获取的时House 如果需要获取houseBeanfactory则需要前缀&  BeanFactory中定义了 String FACTORY_BEAN_PREFIX = "&";
        Object houseBeanfactory1 = applicationContext.getBean("&houseFactoryBean");
        System.out.println(houseBeanfactory1.getClass().getTypeName());
    }
    @Test
    public   void  AnnoScanBeans(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext( SpringConfigTest.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }


    /**
     * xml方式scan获取 扫描注解  获取bean
     */
    public static void xmlscanBeans(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }
    public static  void  xmlConfigBean(){
        /*
          第一种以xml的形式加载 bean
         */
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        Person person = (Person) applicationContext.getBean(Person.class);
        System.out.println(person);//Person{name='张三', sex='男'}
        String[] namesForType = applicationContext.getBeanNamesForType(Person.class);
        for (String s : namesForType) {
            System.out.println(s);//persion
        }
    }
    public static  void  annoConfigBean(){
           /*
           第二种以注解的方式注入容器中的bean
         */
        ApplicationContext applicationContext1 = new AnnotationConfigApplicationContext( SpringConfigTest.class);
        Person person1 = applicationContext1.getBean(Person.class);
        System.out.println(person1);

    }


}
