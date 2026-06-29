package DeepSkill.Mockito.Exercise6;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

public class MyServiceOrderTest {

    @Test
    public void testInteractionOrder() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);
        service.secureFetch(); 
        InOrder inOrder = inOrder(mockApi);
        inOrder.verify(mockApi).authorize();
        inOrder.verify(mockApi).downloadData();
    }
}