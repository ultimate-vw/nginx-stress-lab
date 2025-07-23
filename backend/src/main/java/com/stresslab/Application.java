package com.stresslab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication(scanBasePackages = "com.stresslab")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
