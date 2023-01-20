package com.eduardocode.designpatterns.behavioral.observer.simple;

public interface Subject {
    void subscribe(Subscriber observer1);

    void unsubscribe(Subscriber observer1);

    void notifySubscribers();
}
