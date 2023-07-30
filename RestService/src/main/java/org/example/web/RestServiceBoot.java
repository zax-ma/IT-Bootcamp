package org.example.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.example")
public class RestServiceBoot {

    public static void main(String[] args) {

        SpringApplication.run(RestServiceBoot.class, args);

    }
}