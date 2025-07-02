package com.example;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

public class MyServiceTest {
    @Test
    public void testInteractionOrder() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        service.doActions();

        InOrder inOrder = inOrder(mockApi);
        inOrder.verify(mockApi).firstAction();
        inOrder.verify(mockApi).secondAction();
    }
}