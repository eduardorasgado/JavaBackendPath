package com.eduardocode.designpatterns.behavioral.mediator.colleagues;

public class ConcreteColleagueB extends Colleague {

    public ConcreteColleagueB() {
    }

    public ConcreteColleagueB(Mediator mediator) {
        super(mediator);
    }

    @Override
    void notify(String message) {
        System.out.println("Colleague B received: " + message);
    }
}
