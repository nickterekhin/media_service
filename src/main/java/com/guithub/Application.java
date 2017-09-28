package com.guithub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.guithub")
@ComponentScan("com.guithub")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}