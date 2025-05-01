// src/test/java/com/example/OrderControllerTest.java
package tp3.exo2;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class OrderControllerTest {

    private OrderService orderService; // MOCK de l'interface
    private OrderController orderController;

    @BeforeEach
    void setUp() {
        orderService = Mockito.mock(OrderService.class); // On mocke l'interface
        orderController = new OrderController(orderService);
    }

    @Test
    void testCreateNewOrder() {
        // Arrange
        Order inputOrder = new Order("1", "Test Order");
        Order expectedOrder = new Order("1", "Test Order");

        when(orderService.createOrder(inputOrder)).thenReturn(expectedOrder);

        // Act
        Order result = orderController.createNewOrder(inputOrder);

        // Assert
        assertNotNull(result);
        assertEquals("1", result.getId());
        assertEquals("Test Order", result.getDescription());

        verify(orderService, times(1)).createOrder(inputOrder);
    }
}
