package com.eduardocode.objectorienteddesign.designpatterns.behavioral.mediator.colleagues;

public abstract class Colleague {
    private Mediator mediator;

    public Colleague() {
    }

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
        mediator.setColleague(this);
    }

    public void send(String message) {
        mediator.send(message, this);
    }

    abstract void notify(String message);

    public void setMediator(ConcreteMediator mediator) {
        this.mediator = mediator;
    }
}
