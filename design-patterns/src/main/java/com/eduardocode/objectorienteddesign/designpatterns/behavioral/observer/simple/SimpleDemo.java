package com.eduardocode.objectorienteddesign.designpatterns.behavioral.observer.simple;

public class SimpleDemo {

    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();

        Subscriber observer1 = new ConcreteObserver("Observer 1");
        Subscriber observer2 = new ConcreteObserver("Observer 2");

        subject.subscribe(observer1);
        subject.subscribe(observer2);

        subject.setMessage("Hello World!");

        subject.unsubscribe(observer1);

        subject.setMessage("Goodbye world!");
    }
}
