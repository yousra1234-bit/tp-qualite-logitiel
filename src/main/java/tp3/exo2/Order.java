package tp3.exo2;


public class Order {
    private String id;
    private String description;

    // Constructeurs
    public Order() {}

    public Order(String id, String description) {
        this.id = id;
        this.description = description;
    }

    // Getters et Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
