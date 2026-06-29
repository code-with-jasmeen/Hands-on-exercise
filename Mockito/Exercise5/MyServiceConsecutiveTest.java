package DeepSkill.Mockito.Exercise5;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class MyServiceConsecutiveTest {

    @Test
    public void testMultipleReturnValues() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);
        when(mockApi.getStatus()).thenReturn("Initial Status", "Updated Status");
        String statusOne = service.checkCurrentStatus();
        String statusTwo = service.checkCurrentStatus();
        assertEquals("Initial Status", statusOne);
        assertEquals("Updated Status", statusTwo);
    }
}