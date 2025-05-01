package tp2.exo4;

public class BanqueImpl implements Banque {
    private int solde;

    public BanqueImpl(int soldeInitial) {
        this.solde = soldeInitial;
    }

    @Override
    public void crediter(int somme) {
        if (somme < 0) {
            throw new IllegalArgumentException("Crédit négatif interdit");
        }
        solde += somme;
    }

    @Override
    public boolean est_solvable() {
        return solde >= 0;
    }

    @Override
    public void debiter(int somme) {
        if (somme < 0) {
            throw new IllegalArgumentException("Débit négatif interdit");
        }
        solde -= somme;
    }

    public int getSolde() {
        return solde;
    }
}
