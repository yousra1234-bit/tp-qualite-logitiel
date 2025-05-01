package tp0;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    @Test
    void testCasNormaux() {
        assertEquals(1, Factorial.factorial(0));  // 0! = 1
        assertEquals(1, Factorial.factorial(1));  // 1! = 1
        assertEquals(120, Factorial.factorial(5)); // 5! = 120
    }

    @Test
    void testCasLimites() {
        assertThrows(IllegalArgumentException.class, () -> Factorial.factorial(-1)); // Doit lever une exception
        assertEquals(3_628_800, Factorial.factorial(10)); // 10! = 3 628 800
        assertEquals(2_432_902_008_176_640_000L, Factorial.factorial(20)); // 20! (valeur élevée)
    }
}
