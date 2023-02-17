package com.eduardocode.objectorienteddesign.designpatterns.behavioral.mediator.tv;

public class Button {
    private Mediator mediator;

    public Button(Mediator mediator) {
        this.mediator = mediator;
    }


    public void press() {
        mediator.press();
    }
}
