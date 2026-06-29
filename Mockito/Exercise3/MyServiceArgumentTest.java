package DeepSkill.Mockito.Exercise3;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class MyServiceArgumentTest {

    @Test
    public void testArgumentMatching() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);
        when(mockApi.processData(anyString())).thenReturn("Processed");
        String result = service.executeTask("Some Dynamic Input");
        assertEquals("Processed", result);
        verify(mockApi).processData(anyString());
    }
}