package tp0;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimeTest {

    @Test
    void testCasNormaux() {
        assertTrue(Prime.isPrime(2));   // 2 est premier
        assertTrue(Prime.isPrime(3));   // 3 est premier
        assertFalse(Prime.isPrime(10)); // 10 n'est pas premier
        assertTrue(Prime.isPrime(13));  // 13 est premier
    }

    @Test
    void testCasLimites() {
        assertFalse(Prime.isPrime(0));   // 0 n'est pas premier
        assertFalse(Prime.isPrime(1));   // 1 n'est pas premier
        assertFalse(Prime.isPrime(-5));  // -5 n'est pas premier
        assertTrue(Prime.isPrime(97));   // 97 est un nombre premier
    }
}
