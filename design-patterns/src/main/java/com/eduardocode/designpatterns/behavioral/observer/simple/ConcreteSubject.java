package com.eduardocode.designpatterns.behavioral.observer.simple;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject implements Subject {
    private final List<Subscriber> observers;
    private String message;

    public ConcreteSubject() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void subscribe(Subscriber observer) {
        if(!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void unsubscribe(Subscriber observer) {
        observers.remove(observer);
    }

    public void setMessage(String message) {
        this.message = message;
        notifySubscribers();
    }

    @Override
    public void notifySubscribers() {
        for(Subscriber subscriber : observers) {
            subscriber.update(message);
        }
    }
}
