package com.example;

import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MyServiceTest {
    @Test
    public void testArgumentMatching() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        service.process("Hello");

        // Verify that sendData was called with "Hello"
        verify(mockApi).sendData(eq("Hello"));

        // Or, using any String matcher
        verify(mockApi).sendData(anyString());
    }
}