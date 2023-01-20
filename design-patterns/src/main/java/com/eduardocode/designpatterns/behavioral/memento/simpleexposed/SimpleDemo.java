package com.eduardocode.designpatterns.behavioral.memento.simpleexposed;

public class SimpleDemo {

    public static void main(String[] args) {
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();

        originator.setState("State 1");
        careTaker.add(originator.saveStateToMemento());

        System.out.println("Current State: "+ originator.getState());

        originator.setState("State 2");
        careTaker.add(originator.saveStateToMemento());

        System.out.println("Current State: "+ originator.getState());

        originator.setState("State 3");
        careTaker.add(originator.saveStateToMemento());

        System.out.println("Current State: "+ originator.getState());

        originator.setState("State 4");
        careTaker.add(originator.saveStateToMemento());

        System.out.println("Current State: "+ originator.getState());

        originator.getStateFromMemento(careTaker.get(1));
        System.out.println("Current State: "+ originator.getState());
    }
}
