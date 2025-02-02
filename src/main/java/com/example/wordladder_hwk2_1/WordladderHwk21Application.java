package com.example.wordladder_hwk2_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableWebSecurity
public class WordladderHwk21Application {

    public static void main(String[] args) {
        SpringApplication.run(WordladderHwk21Application.class, args);

    }

    @RequestMapping("/security")
    public String security() {
        return "hello world security";
    }
    @RequestMapping("/hello")
    public String hello() {
        return "welcome";
    }
}
