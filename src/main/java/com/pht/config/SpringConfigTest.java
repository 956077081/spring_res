package com.pht.config;

import com.pht.entity.Person;
import com.pht.entity.User;
import com.pht.filter.ConfigTypeFilter;
import org.springframework.context.annotation.*;


//@ComponentScan(value = {"com.pht"})  //1
//#重新定义Filter includeFilters需要关闭默认的Filters
//@ComponentScan(includeFilters = {//2
//        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class}),
//},useDefaultFilters = false,value = "com.pht")
//Filter的 type类型有多种
/*
   ANNOTATION,  注解式的
    ASSIGNABLE_TYPE, 指定类的
    ASPECTJ,A  aspectj  切面的
    REGEX,  正则的
    CUSTOM;  自定义的
 */
@ComponentScans(value = {//3
        @ComponentScan(includeFilters = {
//                @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})
//                ,@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {UserSerivce.class}),
                @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {ConfigTypeFilter.class}),
        },useDefaultFilters = false,value = "com.pht")
})
@Configuration
public class SpringConfigTest {
    /**
     * 将Person注入到容器中去
     * 方法名称为  组件名称
     *
     * @return
     */
    @Bean
   public Person personBeanName(){
       return  new Person("李四","女");
   }

}
