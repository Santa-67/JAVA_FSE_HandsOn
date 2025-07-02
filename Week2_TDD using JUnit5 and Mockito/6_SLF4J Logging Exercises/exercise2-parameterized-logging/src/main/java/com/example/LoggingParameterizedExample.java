package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingParameterizedExample {
    private static final Logger logger = LoggerFactory.getLogger(LoggingParameterizedExample.class);

    public static void main(String[] args) {
        String user = "Alice";
        int age = 30;
        logger.info("User {} has age {}", user, age);
        logger.warn("User {} is approaching the age limit: {}", user, age);
    }
}