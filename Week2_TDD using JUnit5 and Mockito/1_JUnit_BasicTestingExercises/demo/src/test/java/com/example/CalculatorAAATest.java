package com.example;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorAAATest {
    private Calculator calculator;

    @Before
    public void setUp() {
        // Setup: runs before each test
        calculator = new Calculator();
    }

    @After
    public void tearDown() {
        // Teardown: runs after each test
        calculator = null;
    }

    @Test
    public void testAdd() {
        // Arrange
        int a = 2, b = 3;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(5, result);
    }

    @Test
    public void testSubtract() {
        // Arrange
        int a = 5, b = 2;

        // Act
        int result = calculator.subtract(a, b);

        // Assert
        assertEquals(3, result);
    }
}
