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
                    "Petronilo Paez",
                    "Demo subject",
                    "petronilo@gmail.com",
                    "Description demo"
            );

            Contact demo2 = new Contact(
                    "Sinforosa Lopez",
                    "Subject 2",
                    "sinforosa@gmail.com",
                    "Description2"
            );

            Contact demo3 = new Contact(
                    "Pepito Perez",
                    "Recruiter interested",
                    "pepito@gmail.com",
                    "This is a demo description with demo purpose"
            );
            repository.saveAll(
                    List.of(demo1, demo2, demo3)
            );

        };
    }
}
