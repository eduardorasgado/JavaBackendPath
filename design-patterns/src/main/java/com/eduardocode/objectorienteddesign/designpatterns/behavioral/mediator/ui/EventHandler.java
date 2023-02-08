package com.eduardocode.objectorienteddesign.designpatterns.behavioral.mediator.ui;

public abstract class EventHandler {

    public EventHandler(EventMediator mediator) {
        mediator.register(this);
    }

    public abstract void handle(Event event);
}
