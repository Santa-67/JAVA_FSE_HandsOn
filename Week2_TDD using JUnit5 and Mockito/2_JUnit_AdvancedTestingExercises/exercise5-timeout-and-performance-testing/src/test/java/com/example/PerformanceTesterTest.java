package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PerformanceTesterTest {

    @Test
    void testPerformTaskCompletesWithinTime() {
        PerformanceTester tester = new PerformanceTester();
        assertTimeout(
            java.time.Duration.ofMillis(200),
            tester::performTask
        );
    }
}