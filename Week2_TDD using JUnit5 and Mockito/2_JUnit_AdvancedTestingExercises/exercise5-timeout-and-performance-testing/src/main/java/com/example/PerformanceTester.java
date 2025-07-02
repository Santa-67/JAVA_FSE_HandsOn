package com.example;

public class PerformanceTester {
    public void performTask() {
        // Simulate a task (e.g., sleep for 100 ms)
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}