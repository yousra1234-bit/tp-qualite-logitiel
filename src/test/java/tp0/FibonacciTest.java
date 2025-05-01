package tp0;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    @Test
    void testCasNormaux() {
        assertEquals(0, Fibonacci.fibonacci(0)); // Cas de base
        assertEquals(1, Fibonacci.fibonacci(1)); // Cas de base
        assertEquals(5, Fibonacci.fibonacci(5)); // Valeur intermédiaire
    }

    @Test
    void testCasLimites() {
        assertThrows(IllegalArgumentException.class, () -> Fibonacci.fibonacci(-1)); // Cas négatif
        assertEquals(55, Fibonacci.fibonacci(10)); // Vérification sur un plus grand n
        assertEquals(6765, Fibonacci.fibonacci(20)); // Vérification sur une valeur encore plus grande
    }
}
