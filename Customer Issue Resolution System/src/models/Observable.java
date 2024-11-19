package models;

import java.util.List;

public abstract class Observable {
    List<Observer> observers;

    public void addObserver(Observer obs) {
        this.observers.add(obs);
    }

    protected void notifyObservers(String message) {
        for(Observer obs: observers) {
            obs.apply(message);
        }
    }
}
