package com.alhas2024.spring2024;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
@Bean
    public MyFirstClass myfirsBean(){
        return new MyFirstClass( "My first bean ");
    }

}
