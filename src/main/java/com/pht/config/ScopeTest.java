package com.pht.config;

import com.pht.Beanfactory.HouseFactoryBean;
import com.pht.PhtImportSelector.MyBeanDefinitionRegistrar;
import com.pht.PhtImportSelector.MyBeanImportBeanSelector;
import com.pht.condition.UserCondition;
import com.pht.entity.Disk;
import com.pht.entity.Person;
import com.pht.entity.User;
import org.springframework.context.annotation.*;

@Configuration
/**
 * import的三种用法
 * {@link Configuration}, {@link ImportSelector}, {@link ImportBeanDefinitionRegistrar}
 * or regular component classes to import.
 */
@Import(value = {Disk.class, MyBeanImportBeanSelector.class, MyBeanDefinitionRegistrar.class})

public class ScopeTest {
    /**
     *bean默认为单例模式  singleton  容器加载时  实例化对象
     * prototype  模式  每次   请求都是重新实例化对象   容器加载时 不进行初始化bean  只要获取时才 进行实例化
     * @return
     */
    @Bean
    @Scope(value = "prototype")
    public Person getPerson(){
        System.out.println("实例化对象");
        return new Person("王五","22");
    }

    /**
     * Lazy  懒加载只有在单例下使用  容器加载bean时不会进行初始化  第一次使用初始化
     * @return
     */
    @Bean
    @Lazy
    public User getUser(){
        System.out.println("实例化user");
        return new  User("王五","22");
    }

    /**
     * condiction的使用  加载组件时进行判断是否进行加载
     */
    @Conditional(value = {UserCondition.class})
    @Bean(name = "user01")
    public User  getUser01(){
        return  new User("user1","1");
    }
    /**
     * Bean的加载方式 有多种
     * 1 通过 包扫描 以及组件注解（@Controller @Service)
     * 2 通过  注解@Bean 导入第三包的方式 注册bean
     * 3 通过import的方式来注册  组件
     *      import的三种方式
     *       * {@link Configuration}, {@link ImportSelector}, {@link ImportBeanDefinitionRegistrar}
     *  4  使用spring提供的 bean  factoryBean来注册bean  申明的工厂ping也需要注册
     *
     */
    @Bean(name = "houseFactoryBean")
    public HouseFactoryBean getHouseBeanfactory(){
         return new HouseFactoryBean();
    }

}
