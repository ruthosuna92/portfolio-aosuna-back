package com.example.portfolioaosunaback.externalApi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApiQuotesConfig {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
