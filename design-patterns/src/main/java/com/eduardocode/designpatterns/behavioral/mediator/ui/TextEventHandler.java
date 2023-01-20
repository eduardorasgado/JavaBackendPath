package com.eduardocode.designpatterns.behavioral.mediator.ui;

public class TextEventHandler extends EventHandler {

    public TextEventHandler(EventMediator mediator) {
        super(mediator);
    }

    @Override
    public void handle(Event event) {
        if(event.getType().equals(EventType.TEXT_CHANGE)) {
            System.out.println("Text changed: " + event.getName());
        }
    }
}
