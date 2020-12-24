package com.pht.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * 开启事务
 * 条件@EnableTransactionManagement 以及  注册PlatformTransactionManager
 * 标注@Transactional 对于
 *
 * EnableTransactionManagement 导入2个组件 AutoProxyRegistrar 以及 ProxyTransactionManagementConfiguration
 *   1AutoProxyRegistrar   注册了 InfrastructureAdvisorAutoProxyCreator组件也就相当于一个拦截器  和aop的拦截器相似都是 在beanpostproceeor执行生成一个代理对象
 *   2ProxyTransactionManagementConfiguration 组件
 *      注册了 ：BeanFactoryTransactionAttributeSourceAdvisor 以及 TransactionInterceptor
 *       1BeanFactoryTransactionAttributeSourceAdvisor 解析 transction上的参数
 *       2TransactionInterceptor 为拦截器 ： invokeWithinTransaction()方法 获取拦截器上的属性 ，再获取事务管理器PlatformTransactionManager
 *       再执行 createTransactionIfNecessary ()如果有必要创建事务  proceedWithInvocation（）为执行 带代理对象 方法的  执行proceed()和和aop相似，
 *       拦截方法 执行如果异常 执行 completeTransactionAfterThrowing()执行 事务 回滚 没有异常 执行commitTransactionAfterReturning 提交事务
 *
 */
@EnableTransactionManagement //开启事务
@Configuration
@ComponentScan({"com.pht.dao","com.pht.service"})
public class TxConfig {
    @Bean
    public DataSource getDataSource() throws Exception {
        ComboPooledDataSource comboPooledDataSource= new ComboPooledDataSource();
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("123456");
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        comboPooledDataSource.setDriverClass("com.mysql.jdbc.Driver");
        return comboPooledDataSource;
    }
    @Bean
    public JdbcTemplate getJdbcTemplate() throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        return jdbcTemplate;
    }

    /**
     *事务管理器 开启事务必须要platformTransactionManager
     * @return
     * @throws PropertyVetoException
     */
    @Bean
    public PlatformTransactionManager platformTransactionManager() throws Exception {
        DataSourceTransactionManager sourceTransactionManager = new DataSourceTransactionManager(getDataSource());
        return sourceTransactionManager;
    }
}
