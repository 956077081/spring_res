package com.pht.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;


/**
 * profile选择激活 默认 激活 profile(“default”)
 * 没有对 profile标注的 组件都会注册
 *
 */
@Configuration
@PropertySource("classpath:/jdbc.properties")
public class DataSourceConfig  implements EmbeddedValueResolverAware {
    @Value("${user}") //1 注解属性用法注入
    private  String  user;
    private String driveClass;
    private StringValueResolver stringValueResolver;//解析器
   @Profile({"test","default"})
    @Bean(name = "testDataSource")
    public DataSource getTestDataSource(@Value("${password}") String password) throws PropertyVetoException {//2注解方法参数用法注入
        ComboPooledDataSource  comboPooledDataSource =new ComboPooledDataSource();
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        comboPooledDataSource.setDriverClass(driveClass);
        return comboPooledDataSource;
    }
    @Bean(name = "devDataSource")
    @Profile("dev")
    public DataSource getDevDataSource(@Value("${password}") String password) throws PropertyVetoException {//2注解方法参数用法注入
        ComboPooledDataSource  comboPooledDataSource =new ComboPooledDataSource();
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/dev");
        comboPooledDataSource.setDriverClass(driveClass);
        return comboPooledDataSource;
    }
    @Profile("prod")
    @Bean(name = "prodDataSource")
    public DataSource getProdDataSource(@Value("${password}") String password) throws PropertyVetoException {//2注解方法参数用法注入
        ComboPooledDataSource  comboPooledDataSource =new ComboPooledDataSource();
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/prod");
        comboPooledDataSource.setDriverClass(driveClass);
        return comboPooledDataSource;
    }
    @Override
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        this.stringValueResolver =stringValueResolver;
        this.driveClass = stringValueResolver.resolveStringValue("${driveClass}");
    }
}
