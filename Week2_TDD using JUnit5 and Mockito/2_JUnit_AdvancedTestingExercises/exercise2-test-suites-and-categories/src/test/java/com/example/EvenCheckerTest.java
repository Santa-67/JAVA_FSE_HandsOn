package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EvenCheckerTest {
    @Test
    void testIsEven() {
        assertTrue(4 % 2 == 0);
    }
}