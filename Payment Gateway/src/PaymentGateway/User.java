package PaymentGateway;

public class User {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User(String id) {
        this.id = id;
    }

    String id;
}
