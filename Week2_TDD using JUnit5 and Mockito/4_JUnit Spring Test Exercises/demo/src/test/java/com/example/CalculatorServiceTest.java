package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorServiceTest {

    @Test
    void testAdd() {
        CalculatorService calculatorService = new CalculatorService();
        assertEquals(5, calculatorService.add(2, 3));
        assertEquals(0, calculatorService.add(-2, 2));
        assertEquals(-5, calculatorService.add(-2, -3));
    }
}
