package tp3.exo3;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {

    @Test
    void testGetProduct_Success() throws ApiException {
        // Arrange
        ProductApiClient mockApiClient = mock(ProductApiClient.class);
        ProductService productService = new ProductService(mockApiClient);
        Product expectedProduct = new Product("123", "Laptop");

        when(mockApiClient.getProduct("123")).thenReturn(expectedProduct);

        // Act
        Product result = productService.getProduct("123");

        // Assert
        assertEquals("123", result.getId());
        assertEquals("Laptop", result.getName());
        verify(mockApiClient).getProduct("123");
    }

    @Test
    void testGetProduct_ApiExceptionThrown() throws ApiException {
        // Arrange
        ProductApiClient mockApiClient = mock(ProductApiClient.class);
        ProductService productService = new ProductService(mockApiClient);

        when(mockApiClient.getProduct("404")).thenThrow(new ApiException("Product not found"));

        // Act & Assert
        ApiException thrown = assertThrows(ApiException.class, () -> productService.getProduct("404"));
        assertEquals("Product not found", thrown.getMessage());
        verify(mockApiClient).getProduct("404");
    }

    @Test
    void testGetProduct_InvalidDataFormat() throws ApiException {
        // Arrange
        ProductApiClient mockApiClient = mock(ProductApiClient.class);
        ProductService productService = new ProductService(mockApiClient);

        // Suppose invalid data is simulated by returning a null Product
        when(mockApiClient.getProduct("invalid")).thenReturn(null);

        // Act
        Product result = productService.getProduct("invalid");

        // Assert
        assertNull(result);
        verify(mockApiClient).getProduct("invalid");
    }
}
