package tp2.exo1;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class Exo1Test {

    @Test
    void testAdditionner() {
        // Mocking the Exo1Interface
        Exo1Interface mockExo1 = mock(Exo1Interface.class);

        // Define behavior for the mocked method
        when(mockExo1.additionner(3, 5)).thenReturn(8);

        // Use the mock object in your test
        int result = mockExo1.additionner(3, 5);

        // Verify the result
        assertEquals(8, result);
    }

    @Test
    void testGetResult() {
        // Mocking the Exo1Interface
        Exo1Interface mockExo1 = mock(Exo1Interface.class);

        // Define behavior for the mocked method
        when(mockExo1.getResult()).thenReturn(10);

        // Use the mock object in your test
        int result = mockExo1.getResult();

        // Verify the result
        assertEquals(10, result);
    }
}
