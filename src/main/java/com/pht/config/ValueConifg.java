package com.pht.config;

import com.pht.entity.value.School;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = {"classpath:/school.properties"})
public class ValueConifg {

    @Bean
    public School school(){
        return  new School();
    }

}
