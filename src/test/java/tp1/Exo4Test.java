package tp1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Exo4Test {

    @Test
    public void testSolve_TwoRealRoots() {
        // Test avec deux racines réelles distinctes
        double[] roots = Exo4.solve(1, -3, 2);  // x^2 - 3x + 2 = 0
        assertEquals(2, roots[0], "La première racine doit être 2");
        assertEquals(1, roots[1], "La deuxième racine doit être 1");
    }

    @Test
    public void testSolve_OneRealRoot() {
        // Test avec une seule racine réelle
        double[] roots = Exo4.solve(1, -2, 1);  // x^2 - 2x + 1 = 0
        assertEquals(1, roots[0], "La racine doit être 1");
    }

    @Test
    public void testSolve_NoRealRoots() {
        // Test avec aucune racine réelle (delta < 0)
        double[] roots = Exo4.solve(1, 1, 1);  // x^2 + x + 1 = 0
        assertNull(roots, "Il n'y a pas de racines réelles, le résultat doit être null");
    }

    @Test
    public void testSolve_AIsZero() {
        // Test avec a = 0 (doit lancer une exception)
        assertThrows(IllegalArgumentException.class, () -> Exo4.solve(0, 2, 1), "L'argument a ne doit pas être zéro");
    }

    @Test
    public void testSolve_ZeroDiscriminant() {
        // Test avec delta = 0 (une seule racine réelle)
        double[] roots = Exo4.solve(1, -4, 4);  // x^2 - 4x + 4 = 0
        assertEquals(2, roots[0], "La racine doit être 2");
    }
}
