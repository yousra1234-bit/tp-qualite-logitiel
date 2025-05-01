package tp2.ex2etex3;


public class Utilisateur {
    private String prenom;
    private String nom;
    private String email;
    private int id;

    public Utilisateur(String prenom, String nom, String email) {
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
    }

    public String getPrenom() { return prenom; }
    public String getNom() { return nom; }
    public String getEmail() { return email; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
}
