package com.example.springbootexersicemain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SpringBootExersiceMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootExersiceMainApplication.class, args);
    }
}
