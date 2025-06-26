package com.example;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.InOrder;

public class MyServiceTest {
    @Test
    public void testExternalApi() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("Mock Data");
        MyService service = new MyService(mockApi);
        String result = service.fetchData();
        assertEquals("Mock Data", result);
    }

    @Test
    public void testVerifyInteraction() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);
        service.fetchData();
        verify(mockApi).getData();
    }

    @Test
    public void testArgumentMatching() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        service.fetchDataById(42);

        verify(mockApi).getDataById(eq(42)); // Verifies method called with argument 42
        verifyNoMoreInteractions(mockApi);   // Ensures no other interactions
    }

    @Test
    public void testVoidMethod() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        // Optionally stub the void method (not required unless you want to do something special)
        doNothing().when(mockApi).sendData(anyString());

        service.sendDataToApi("Hello");

        verify(mockApi).sendData(eq("Hello")); // Verify interaction
    }

    @Test
    public void testVoidMethodThrowsException() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        // Stub the void method to throw an exception
        doThrow(new RuntimeException("API error")).when(mockApi).sendData("fail");

        // Verify that the exception is thrown when calling the service method
        assertThrows(RuntimeException.class, () -> service.sendDataToApi("fail"));

        // Verify the interaction
        verify(mockApi).sendData("fail");
    }

    @Test
    public void testMultipleReturns() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.getData())
            .thenReturn("First Call")
            .thenReturn("Second Call")
            .thenReturn("Third Call");

        MyService service = new MyService(mockApi);

        String result1 = service.fetchData();
        String result2 = service.fetchData();
        String result3 = service.fetchData();

        assertEquals("First Call", result1);
        assertEquals("Second Call", result2);
        assertEquals("Third Call", result3);
    }

    @Test
    public void testInteractionOrder() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        // Call methods in a specific order
        service.fetchData();
        service.sendDataToApi("OrderTest");

        // Verify the order of interactions
        InOrder inOrder = Mockito.inOrder(mockApi);
        inOrder.verify(mockApi).getData();
        inOrder.verify(mockApi).sendData("OrderTest");
    }
}
