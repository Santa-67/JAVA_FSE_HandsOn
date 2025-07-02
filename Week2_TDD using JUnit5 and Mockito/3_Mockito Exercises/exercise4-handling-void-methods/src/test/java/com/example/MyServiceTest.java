package com.example;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MyServiceTest {
    @Test
    public void testVoidMethod() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        // Optionally stub the void method (not required unless you want to do something special)
        doNothing().when(mockApi).logAction(anyString());

        MyService service = new MyService(mockApi);
        service.doSomething();

        // Verify the void method was called with the expected argument
        verify(mockApi).logAction("Did something");
    }
}