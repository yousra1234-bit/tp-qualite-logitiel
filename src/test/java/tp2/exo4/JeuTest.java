package tp2.exo4;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class JeuTest {
    private Banque banque;
    private Joueur joueur;
    private De de1;
    private De de2;
    private Jeu jeu;

    @BeforeEach
    public void setup() {
        banque = mock(Banque.class);
        joueur = mock(Joueur.class);
        de1 = mock(De.class);
        de2 = mock(De.class);
        jeu = new Jeu(banque);
    }

    @Test
    public void testJeuFerme_ProvoqueException() {
        jeu.fermer();
        assertThrows(JeuFermeException.class, () -> jeu.jouer(joueur, de1, de2));
    }

    @Test
    public void testJoueurInsolvable_AucunLancerEffectue() throws DebitImpossibleException, JeuFermeException {
        when(joueur.mise()).thenReturn(10);
        doThrow(new DebitImpossibleException("solde insuffisant")).when(joueur).debiter(10);

        jeu.jouer(joueur, de1, de2);

        verify(joueur).mise();
        verify(joueur).debiter(10);
        verifyNoMoreInteractions(joueur);
        verifyNoInteractions(de1, de2, banque);
    }

    @Test
    public void testJoueurPerd_MiseNonGagnante() throws DebitImpossibleException, JeuFermeException {
        when(joueur.mise()).thenReturn(10);
        when(de1.lancer()).thenReturn(3);
        when(de2.lancer()).thenReturn(4); // somme = 7 => gagnant
        doNothing().when(joueur).debiter(10);
        when(banque.est_solvable()).thenReturn(true);

        jeu.jouer(joueur, de1, de2);

        verify(joueur).debiter(10);
        verify(banque).crediter(10);
        verify(de1).lancer();
        verify(de2).lancer();
        verify(joueur).crediter(20);
        verify(banque).debiter(20);
        verify(banque).est_solvable();
        assertTrue(jeu.estOuvert());
    }

    @Test
    public void testGagnantEtBanqueInsolvable_JeuFerme() throws DebitImpossibleException, JeuFermeException {
        when(joueur.mise()).thenReturn(20);
        doNothing().when(joueur).debiter(20);
        when(de1.lancer()).thenReturn(3);
        when(de2.lancer()).thenReturn(4); // somme = 7
        when(banque.est_solvable()).thenReturn(false);

        jeu.jouer(joueur, de1, de2);

        verify(joueur).crediter(40);
        verify(banque).debiter(40);
        assertFalse(jeu.estOuvert());
    }

    @Test
    public void testJoueurPerd_SommePasEgaleA7() throws DebitImpossibleException, JeuFermeException {
        when(joueur.mise()).thenReturn(10);
        doNothing().when(joueur).debiter(10);
        when(de1.lancer()).thenReturn(2);
        when(de2.lancer()).thenReturn(3); // somme = 5, perdant

        jeu.jouer(joueur, de1, de2);

        verify(banque).crediter(10);
        verify(joueur, never()).crediter(anyInt());
        verify(banque, never()).debiter(anyInt());
        verify(banque, never()).est_solvable();
        assertTrue(jeu.estOuvert());
    }
}
