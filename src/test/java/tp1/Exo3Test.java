package tp1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Exo3Test {

    @Test
    public void testBinarySearch_FoundElement() {
        // Test pour un élément trouvé dans un tableau trié
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertEquals(4, Exo3.binarySearch(array, 5), "L'élément 5 doit être trouvé à l'indice 4");
        assertEquals(2, Exo3.binarySearch(array, 3), "L'élément 3 doit être trouvé à l'indice 2");
        assertEquals(0, Exo3.binarySearch(array, 1), "L'élément 1 doit être trouvé à l'indice 0");
    }

    @Test
    public void testBinarySearch_ElementNotFound() {
        // Test pour un élément non trouvé dans le tableau
        int[] array = {1, 2, 3, 4, 5};
        assertEquals(-1, Exo3.binarySearch(array, 6), "L'élément 6 n'est pas présent, doit renvoyer -1");
        assertEquals(-1, Exo3.binarySearch(array, 0), "L'élément 0 n'est pas présent, doit renvoyer -1");
        assertEquals(-1, Exo3.binarySearch(array, 10), "L'élément 10 n'est pas présent, doit renvoyer -1");
    }

    @Test
    public void testBinarySearch_EmptyArray() {
        // Test pour un tableau vide
        int[] array = {};
        assertEquals(-1, Exo3.binarySearch(array, 5), "Le tableau est vide, doit renvoyer -1");
    }

    @Test
    public void testBinarySearch_NullArray() {
        // Test avec un tableau null, doit lancer une exception
        assertThrows(NullPointerException.class, () -> Exo3.binarySearch(null, 5), "Une exception NullPointerException doit être lancée pour un tableau null");
    }

    @Test
    public void testBinarySearch_SingleElementArray() {
        // Test pour un tableau avec un seul élément
        int[] array = {5};
        assertEquals(0, Exo3.binarySearch(array, 5), "Le seul élément du tableau doit être trouvé à l'indice 0");
        assertEquals(-1, Exo3.binarySearch(array, 3), "L'élément 3 n'est pas présent, doit renvoyer -1");
    }

    @Test
    public void testBinarySearch_LargeArray() {
        // Test de performance avec un grand tableau
        int[] array = new int[1000000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1; // Remplir le tableau avec des entiers de 1 à 1000000
        }
        assertEquals(999999, Exo3.binarySearch(array, 1000000), "L'élément 1000000 doit être trouvé à l'indice 999999");
        assertEquals(-1, Exo3.binarySearch(array, 1000001), "L'élément 1000001 n'est pas présent, doit renvoyer -1");
    }
}
