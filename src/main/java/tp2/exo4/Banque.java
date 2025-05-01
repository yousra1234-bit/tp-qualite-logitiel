package tp2.exo4;

public interface Banque {
    void crediter(int somme);
    boolean est_solvable();
    void debiter(int somme);
}