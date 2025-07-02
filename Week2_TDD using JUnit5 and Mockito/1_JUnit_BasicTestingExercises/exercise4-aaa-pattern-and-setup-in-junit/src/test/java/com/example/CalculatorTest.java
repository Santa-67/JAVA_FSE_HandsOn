package com.example;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {
    private Calculator calculator;

    @Before
    public void setUp() {
        // Arrange: setup test fixture
        calculator = new Calculator();
    }

    @After
    public void tearDown() {
        // Teardown: clean up after test
        calculator = null;
    }

    @Test
    public void testAdd() {
        // Arrange is done in setUp()
        // Act
        int result = calculator.add(2, 3);
        // Assert
        assertEquals(5, result);
    }

    @Test
    public void testSubtract() {
        // Arrange is done in setUp()
        // Act
        int result = calculator.subtract(5, 2);
        // Assert
        assertEquals(3, result);
    }
}