package com.cognizant.jwt_learn.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    // Secret key must be at least 32 characters (256 bits)
    private static final String SECRET = "my_super_secure_secret_key_123456";
    private static final SecretKey KEY = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("Start authenticate()");
        LOGGER.debug("Authorization Header: {}", authHeader);

        String username = getUser(authHeader);
        LOGGER.debug("Decoded Username: {}", username);

        String token = generateJwt(username);
        LOGGER.debug("Generated Token: {}", token);

        Map<String, String> map = new HashMap<>();
        map.put("token", token);

        LOGGER.info("End authenticate()");
        return map;
    }

    private String getUser(String authHeader) {
        LOGGER.info("Start getUser()");

        String base64Credentials = authHeader.substring("Basic ".length());
        LOGGER.debug("Base64 Encoded Credentials: {}", base64Credentials);

        byte[] decodedBytes = Base64.getDecoder().decode(base64Credentials);
        String decodedString = new String(decodedBytes);
        LOGGER.debug("Decoded Credentials String: {}", decodedString);

        String username = decodedString.split(":", 2)[0];
        LOGGER.info("End getUser()");

        return username;
    }

    private String generateJwt(String user) {
        LOGGER.info("Start generateJwt()");

        String token = Jwts.builder()
                .setSubject(user)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1200000)) // 20 min
                .signWith(KEY, SignatureAlgorithm.HS256)
                .compact();

        LOGGER.info("End generateJwt()");
        return token;
    }
}
