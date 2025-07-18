package com.cognizant.resourceserver.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecureController {

    @GetMapping("/")
    public String publicEndpoint() {
        return "🌐 Public endpoint";
    }

    @GetMapping("/secure")
    public String secureEndpoint() {
        return "🔐 Secure endpoint – JWT required!";
    }
}

