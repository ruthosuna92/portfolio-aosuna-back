package com.example.portfolioaosunaback.contact;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ContactConfig {
    @Bean
    CommandLineRunner commandLineRunner(ContactRepository repository){
        return args -> {
            Contact demo1 = new Contact(
                    "Demo name",
                    "Demo subject",
                    "demo@gmail.com",
                    "Description demo"
            );

            Contact demo2 = new Contact(
                    "Demo 2",
                    "Subject 2",
                    "demo2@gmail.com",
                    "Description2"
            );
            repository.saveAll(
                    List.of(demo1, demo2)
            );

        };
    }
}
