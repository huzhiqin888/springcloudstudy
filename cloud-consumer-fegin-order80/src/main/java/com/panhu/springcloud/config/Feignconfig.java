package com.panhu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Feignconfig {
    @Bean
    Logger.Level feignloggerlevel(){
        return Logger.Level.FULL;
    }
}
