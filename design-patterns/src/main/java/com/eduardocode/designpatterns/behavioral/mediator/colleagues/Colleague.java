package com.eduardocode.designpatterns.behavioral.mediator.colleagues;

public abstract class Colleague {
    private Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    public void send(String message) {
        mediator.send(message, this);
    }

    abstract void notify(String message);
}
