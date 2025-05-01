package tp1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class Exo6Test {

    @Test
    public void testFizzBuzz_DivisibleBy3() {
        assertEquals("Fizz", Exo6.fizzBuzz(3));
        assertEquals("Fizz", Exo6.fizzBuzz(6));
        assertEquals("Fizz", Exo6.fizzBuzz(9));
    }

    @Test
    public void testFizzBuzz_DivisibleBy5() {
        assertEquals("Buzz", Exo6.fizzBuzz(5));
        assertEquals("Buzz", Exo6.fizzBuzz(10));
        assertEquals("Buzz", Exo6.fizzBuzz(20)); // ajout
    }

    @Test
    public void testFizzBuzz_DivisibleBy3And5() {
        assertEquals("FizzBuzz", Exo6.fizzBuzz(15));
        assertEquals("FizzBuzz", Exo6.fizzBuzz(30));
        assertEquals("FizzBuzz", Exo6.fizzBuzz(45)); // ajout
    }

    @Test
    public void testFizzBuzz_NotDivisibleBy3Or5() {
        assertEquals("1", Exo6.fizzBuzz(1));
        assertEquals("2", Exo6.fizzBuzz(2)); // ajout
        assertEquals("4", Exo6.fizzBuzz(4)); // ajout
        assertEquals("7", Exo6.fizzBuzz(7));
        assertEquals("8", Exo6.fizzBuzz(8));
        assertEquals("11", Exo6.fizzBuzz(11)); // ajout
    }

    @Test
    public void testFizzBuzz_InvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> Exo6.fizzBuzz(0));
        assertThrows(IllegalArgumentException.class, () -> Exo6.fizzBuzz(-1)); // ajout
        assertThrows(IllegalArgumentException.class, () -> Exo6.fizzBuzz(-5));
    }
}
