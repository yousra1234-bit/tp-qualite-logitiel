package tp1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Exo5Test {

    @Test
    public void testToRoman_AllSymbolsUsed() {
        assertEquals("I", Exo5.toRoman(1));
        assertEquals("II", Exo5.toRoman(2));
        assertEquals("III", Exo5.toRoman(3));
        assertEquals("IV", Exo5.toRoman(4));
        assertEquals("V", Exo5.toRoman(5));
        assertEquals("VI", Exo5.toRoman(6));
        assertEquals("IX", Exo5.toRoman(9));
        assertEquals("X", Exo5.toRoman(10));
        assertEquals("XL", Exo5.toRoman(40));
        assertEquals("L", Exo5.toRoman(50));
        assertEquals("XC", Exo5.toRoman(90));
        assertEquals("C", Exo5.toRoman(100));
        assertEquals("CD", Exo5.toRoman(400));
        assertEquals("D", Exo5.toRoman(500));
        assertEquals("CM", Exo5.toRoman(900));
        assertEquals("M", Exo5.toRoman(1000));
    }

    @Test
    public void testToRoman_ComplexValues() {
        assertEquals("XI", Exo5.toRoman(11));        // 10 + 1
        assertEquals("LVIII", Exo5.toRoman(58));     // 50 + 5 + 3
        assertEquals("CXLIV", Exo5.toRoman(144));    // 100 + 40 + 4
        assertEquals("DCCCXC", Exo5.toRoman(890));   // 500 + 100 + 100 + 100 + 90
        assertEquals("MCMXCIV", Exo5.toRoman(1994)); // 1000 + 900 + 90 + 4
    }

    @Test
    public void testToRoman_BoundaryValues() {
        assertEquals("I", Exo5.toRoman(1));               // lower bound
        assertEquals("MMMCMXCIX", Exo5.toRoman(3999));    // upper bound
    }

    @Test
    public void testToRoman_InvalidValues() {
        assertThrows(IllegalArgumentException.class, () -> Exo5.toRoman(0));
        assertThrows(IllegalArgumentException.class, () -> Exo5.toRoman(-1));
        assertThrows(IllegalArgumentException.class, () -> Exo5.toRoman(4000));
    }
}
