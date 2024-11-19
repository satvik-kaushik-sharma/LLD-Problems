package models;

public abstract class Observer {

    public void apply(String message) {
        System.out.println("Notification Received: " + message);
    }
}
