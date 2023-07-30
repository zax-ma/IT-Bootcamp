package org.example.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.example.service")
public class UserServiceBoot {
    public static void main(String[] args) {

        SpringApplication.run(UserServiceBoot.class, args);
    }
}