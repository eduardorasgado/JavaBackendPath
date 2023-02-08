package com.eduardocode.objectorienteddesign.designpatterns.behavioral.mediator.colleagues;

public class ConcreteColleagueC extends Colleague {

    public ConcreteColleagueC() {
    }

    public ConcreteColleagueC(Mediator mediator) {
        super(mediator);
    }

    @Override
    void notify(String message) {
        System.out.println("Colleague C received: " + message);
    }
}
