package com.eduardocode.objectorienteddesign.designpatterns.behavioral.mediator.ui;

public class UiDemo {

    public static void main(String[] args) {
        EventMediator mediator = new EventMediatorImpl();

        EventHandler buttonHandler = new ButtonEventHandler(mediator);
        EventHandler textHandler = new TextEventHandler(mediator);

        Event buttonClickEvent = new Event(EventType.BUTTON_CLICK, "New Button");
        Event textChangeEvent = new Event(EventType.TEXT_CHANGE, "New Text");

        mediator.send(buttonClickEvent);
        mediator.send(textChangeEvent);

        mediator.remove(buttonHandler);
        // wont do nothing
        mediator.send(buttonClickEvent);
    }
}
