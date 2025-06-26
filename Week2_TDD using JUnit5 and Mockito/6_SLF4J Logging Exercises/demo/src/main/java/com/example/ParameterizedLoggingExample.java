package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {
        String user = "Alice";
        int age = 30;
        logger.info("User {} is {} years old", user, age);
        logger.warn("User {} has reached age threshold: {}", user, age);
    }
}