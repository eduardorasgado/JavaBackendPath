package com.eduardocode.designpatterns.behavioral.mediator.ui;

public interface EventMediator {

    void register(EventHandler eventHandler);

    void remove(EventHandler eventHandler);

    void send(Event buttonClickEvent);
}
