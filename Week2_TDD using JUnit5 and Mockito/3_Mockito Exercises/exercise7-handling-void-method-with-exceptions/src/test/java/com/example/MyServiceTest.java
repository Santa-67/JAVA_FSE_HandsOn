package com.example;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MyServiceTest {
    @Test
    public void testVoidMethodThrowsException() {
        ExternalApi mockApi = mock(ExternalApi.class);

        // Stub the void method to throw an exception
        doThrow(new RuntimeException("Failure")).when(mockApi).riskyAction();

        MyService service = new MyService(mockApi);

        // Assert that the exception is thrown
        assertThrows(RuntimeException.class, service::performRiskyAction);

        // Verify the interaction
        verify(mockApi).riskyAction();
    }
}