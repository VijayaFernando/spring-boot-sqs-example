package com.example.springbootsqsexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootSqsExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSqsExampleApplication.class, args);
    }


}
