package com.cognizant.jwt_learn.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    private final Key key = Keys.hmacShaKeyFor("thisIsASecretKeyThatIsExactly32Bytes!".getBytes());

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1200000)) // 20 min
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }
}
