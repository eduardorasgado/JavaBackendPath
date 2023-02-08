package com.eduardocode.objectorienteddesign.designpatterns.behavioral.memento.simpleprotected;

public class ProtectedMementoDemo {

    public static void main(String[] args) {
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();

        originator.setState("State 1");
        careTaker.add(originator);

        originator.doSomethingPublic();

        originator.setState("State 2");
        careTaker.add(originator);

        originator.doSomethingPublic();

        originator.setState("State 3");
        careTaker.add(originator);

        originator.doSomethingPublic();

        originator.setState("State 4");
        careTaker.add(originator);

        originator.doSomethingPublic();

        careTaker.restore(originator, 1);

        originator.doSomethingPublic();
    }
}
