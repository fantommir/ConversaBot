package com.example.apis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ApisApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApisApplication.class, args);
    }

}
