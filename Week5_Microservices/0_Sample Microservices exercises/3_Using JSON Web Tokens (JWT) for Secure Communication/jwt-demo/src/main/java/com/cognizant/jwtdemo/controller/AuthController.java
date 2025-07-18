package com.cognizant.jwtdemo.controller;

import com.cognizant.jwtdemo.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @GetMapping("/public")
    public String publicEndpoint() {
        return "🌍 Public endpoint";
    }

    @PostMapping("/auth")
    public String authenticate(@RequestParam String username) {
        return jwtTokenProvider.createToken(username);
    }

    @GetMapping("/secure")
    public String secureEndpoint() {
        return "🔐 Secure endpoint - JWT required";
    }
}
