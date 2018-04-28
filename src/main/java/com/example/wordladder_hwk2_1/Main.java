package com.example.wordladder_hwk2_1;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
public class Main {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("may"));
    }
}