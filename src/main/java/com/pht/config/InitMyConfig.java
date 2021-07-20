package com.pht.config;

import com.pht.entity.Computer;
import com.pht.entity.Cup;
import com.pht.entity.Water;
import com.pht.entity.springApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Configuration
public class InitMyConfig {
    /**
     * bean的生命周期
     *
     *  1 initMethod 初始化方法 容器注入时运行 ，destroyMethod    bean销毁时 调用 但是当@scope为多实例为  容器不在调用 bean的销毁方法
     *  2  bean   更具 jsr  250 提供的 PreDestroy在容器销毁bean之前和 PostConstruct   （在bean完成赋值以后进行） 进行初始化
     * @return
     */
    @Bean(name = "water",initMethod = "init",destroyMethod = "destroybean")
    public Water getWater(){
            return new Water();
    }

    @Bean(name = "cup")
    public Cup getCup(){
        return new Cup();
    }
    @Bean(name = "computer")
    public Computer getComputer(){
        return  new Computer();
    }
    @Bean
    public springApplication springApplication(){
        return new springApplication();
    }

}
