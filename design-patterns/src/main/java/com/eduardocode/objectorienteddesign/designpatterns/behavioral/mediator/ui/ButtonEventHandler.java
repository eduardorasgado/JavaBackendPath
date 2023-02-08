package com.eduardocode.objectorienteddesign.designpatterns.behavioral.mediator.ui;

public class ButtonEventHandler extends EventHandler {

    public ButtonEventHandler(EventMediator mediator) {
        super(mediator);
    }

    @Override
    public void handle(Event event) {
        if(event.getType().equals(EventType.BUTTON_CLICK)) {
            System.out.println("Button clicked: " + event.getName());
        }
    }
}
