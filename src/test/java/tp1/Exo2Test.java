package tp1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Exo2Test {

    @Test
    void testIsAnagram_ValidCases() {
        assertAll(
                () -> assertTrue(Exo2.isAnagram("chien", "niche")),
                () -> assertTrue(Exo2.isAnagram("Listen", "Silent")),
                () -> assertTrue(Exo2.isAnagram("abc", "cab")),
                () -> assertTrue(Exo2.isAnagram("conversation", "voices rant on"))
        );
    }

    @Test
    void testIsAnagram_InvalidCases() {
        assertAll(
                () -> assertFalse(Exo2.isAnagram("chien", "chat")),
                () -> assertFalse(Exo2.isAnagram("hello", "world")),
                () -> assertFalse(Exo2.isAnagram("abc", "abcc")),
                () -> assertFalse(Exo2.isAnagram("a", "aa"))
        );
    }

    @Test
    void testIsAnagram_EmptyStrings() {
        assertTrue(Exo2.isAnagram("", ""));
    }

    @Test
    void testIsAnagram_NullInputs() {
        assertAll(
                () -> assertThrows(NullPointerException.class, () -> Exo2.isAnagram(null, "abc")),
                () -> assertThrows(NullPointerException.class, () -> Exo2.isAnagram("abc", null)),
                () -> assertThrows(NullPointerException.class, () -> Exo2.isAnagram(null, null))
        );
    }

    @Test
    void testIsAnagram_WithSpaces() {
        assertTrue(Exo2.isAnagram("Tom Marvolo Riddle", "I am Lord Voldemort"));
    }

    @Test
    void testIsAnagram_SingleCharacter() {
        assertTrue(Exo2.isAnagram("a", "a"));
        assertFalse(Exo2.isAnagram("a", "b"));
    }

    @Test
    void testIsAnagram_LargeInput() {
        String s1 = "a".repeat(100000) + "b".repeat(100000);
        String s2 = "b".repeat(100000) + "a".repeat(100000);
        assertTrue(Exo2.isAnagram(s1, s2));
    }

    @Test
    void testIsAnagram_IdenticalStrings() {
        assertTrue(Exo2.isAnagram("java", "java"));
    }
}
