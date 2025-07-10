package com.cognizant.jwt_learn.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, AuthenticationManager authenticationManager) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/authenticate").hasAnyRole("USER", "ADMIN")
                .anyRequest().authenticated()
            )
            .httpBasic() // still allows basic auth for /authenticate
            .and()
            .addFilter(new JwtAuthorizationFilter(authenticationManager)); // ✅ JWT filter added

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        LOGGER.info("Start passwordEncoder()");
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        LOGGER.info("Start userDetailsService()");
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User
                .withUsername("admin")
                .password(passwordEncoder.encode("pwd"))
                .roles("ADMIN")
                .build());
        manager.createUser(User
                .withUsername("user")
                .password(passwordEncoder.encode("pwd"))
                .roles("USER")
                .build());
        return manager;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }
}
