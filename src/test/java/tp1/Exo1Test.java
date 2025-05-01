package tp1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Exo1Test {

    @Test
    void testIsPalindromeNull() {
        // Condition : chaîne nulle
        assertThrows(NullPointerException.class, () -> Exo1.isPalindrome(null),
                "La chaîne nulle devrait lever une exception NullPointerException");
    }

    @Test
    void testIsPalindromeEmpty() {
        // Cas d'une chaîne vide
        assertTrue(Exo1.isPalindrome(""), "Une chaîne vide devrait être considérée comme un palindrome");
    }

    @Test
    void testIsPalindromeSimpleTrue() {
        // Cas d'un palindrome simple
        assertTrue(Exo1.isPalindrome("kayak"), "kayak devrait être un palindrome");
    }

    @Test
    void testIsPalindromeSimpleFalse() {
        // Cas où la chaîne n'est pas un palindrome
        assertFalse(Exo1.isPalindrome("hello"), "hello ne devrait pas être un palindrome");
    }

    @Test
    void testIsPalindromeWithSpaces() {
        // Cas avec des espaces (le palindrome ignore les espaces)
        assertTrue(Exo1.isPalindrome("Esope reste ici et se repose"),
                "La phrase 'Esope reste ici et se repose' devrait être un palindrome");
    }

    @Test
    void testIsPalindromeWithMixedCase() {
        // Cas avec des lettres en majuscule et minuscule
        assertTrue(Exo1.isPalindrome("A man a plan a canal Panama"),
                "La phrase 'A man a plan a canal Panama' devrait être un palindrome");
    }

    @Test
    void testIsPalindromeWithNonMatchingCharacters() {
        // Cas où les caractères ne correspondent pas
        assertFalse(Exo1.isPalindrome("abcdefg"), "abcdefg ne devrait pas être un palindrome");
    }
}
