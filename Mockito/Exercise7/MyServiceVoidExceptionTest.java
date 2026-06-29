package DeepSkill.Mockito.Exercise7;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class MyServiceVoidExceptionTest {

    @Test
    public void testVoidMethodException() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);
        doThrow(new RuntimeException("Connection Timeout"))
            .when(mockApi).sendPayload(anyString());
        assertThrows(RuntimeException.class, () -> {
            service.dispatchData("Sample Payload");
        });
        verify(mockApi).sendPayload("Sample Payload");
    }
}