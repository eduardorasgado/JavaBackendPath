package com.eduardocode.designpatterns.behavioral.observer.stock;

public interface Subject {
    void subscribe(Observer observer);
    void unsubscribe(Observer observer);
    void notifyObservers();
}
