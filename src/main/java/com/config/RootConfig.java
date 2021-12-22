package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@ComponentScan({"com.model", "com.repository"})
@PropertySource("classpath:application.properties")
@Configuration
public class RootConfig implements WebMvcConfigurer {
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
