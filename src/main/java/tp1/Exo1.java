package tp1;

public class Exo1 {
    public static boolean isPalindrome(String s) {
        if (s == null) {
            throw new NullPointerException("String must not be null");
        }
        s = s.toLowerCase().replaceAll("\\s+", ""); // Retirer les espaces et convertir en minuscule
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            j++; // Incrémenter i
            i--; // Décrémenter j
        }
        return true; // Si tous les caractères correspondent, c'est un palindrome
    }
}
