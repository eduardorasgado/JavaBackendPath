package com.eduardocode.designpatterns.behavioral.mediator.colleagues;

public class ConcreteColleagueA extends Colleague {
    public ConcreteColleagueA(Mediator mediator) {
        super(mediator);
    }

    @Override
    void notify(String message) {
        System.out.println("Colleage A received: " + message);
    }
}
