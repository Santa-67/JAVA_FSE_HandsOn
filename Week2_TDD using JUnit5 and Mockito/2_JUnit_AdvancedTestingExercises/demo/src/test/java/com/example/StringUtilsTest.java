package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsTest {
    @Test
    void testIsEmpty() {
        assertTrue(isEmpty(""));
        assertFalse(isEmpty("hello"));
    }

    // Simple utility method for demonstration
    boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }
}
