package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
@Slf4j
public class ReflectionApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReflectionApplication.class, args);
    }

}
