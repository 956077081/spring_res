package com.pht.config;

import com.pht.entity.Computer;
import com.pht.test.init.InitTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitMyConfig2  {
    @Bean(name = "computer")
    public Computer getComputer(){
        return  new Computer();
    }
    @Bean(initMethod = "init")
    public InitTest InitTest(){
        return new InitTest();
    }
}
