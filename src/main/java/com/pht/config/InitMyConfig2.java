package com.pht.config;

import com.pht.entity.Computer;
import com.pht.entity.Cup;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitMyConfig2  {
//    @Bean(name = "computer")
//    public Computer getComputer(){
//        return  new Computer();
//    }
    @Bean(name = "cup",initMethod = "initMethod")
    public Cup getCup(){
        return  new Cup();
    }
}
