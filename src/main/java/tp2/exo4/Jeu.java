package tp2.exo4;
public class Jeu {
    private boolean ouvert;
    private final Banque banque;

    public Jeu(Banque banque) {
        this.banque = banque;
        this.ouvert = true;
    }

    public void fermer() {
        this.ouvert = false;
    }

    public boolean estOuvert() {
        return ouvert;
    }

    public void jouer(Joueur joueur, De de1, De de2) throws JeuFermeException {
        if (!ouvert) {
            throw new JeuFermeException("Le jeu est fermé");
        }

        int mise = joueur.mise();

        try {
            joueur.debiter(mise);
        } catch (DebitImpossibleException e) {
            return; // joueur insolvable, on arrête
        }

        banque.crediter(mise);

        int somme = de1.lancer() + de2.lancer();

        if (somme == 7) {
            int gain = mise * 2;
            joueur.crediter(gain);
            banque.debiter(gain);

            if (!banque.est_solvable()) {
                fermer();
            }
        }
    }
}
