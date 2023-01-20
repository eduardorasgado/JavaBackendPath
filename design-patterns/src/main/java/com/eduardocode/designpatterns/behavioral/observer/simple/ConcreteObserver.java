package com.eduardocode.designpatterns.behavioral.observer.simple;

public class ConcreteObserver implements Subscriber {
    private final String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received message: " + message);
    }
}
