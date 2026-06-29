package DeepSkill.Mockito.Exercise4;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

public class MyServiceVoidTest {

    @Test
    public void testVoidMethod() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);
        doNothing().when(mockApi).logAction(anyString());
        service.performActionAndLog("User login event");
        verify(mockApi).logAction("User login event");
    }
}