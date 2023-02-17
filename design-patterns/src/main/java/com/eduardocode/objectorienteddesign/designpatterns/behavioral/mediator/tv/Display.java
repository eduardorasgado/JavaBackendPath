package com.eduardocode.objectorienteddesign.designpatterns.behavioral.mediator.tv;

public class Display {
    private Mediator mediator;

    public Display(Mediator mediator) {
        this.mediator = mediator;
    }

    public void turnOn() {
        System.out.println("Display is turned on.");
    }

    public void turnOff() {
        System.out.println("Display is turned off.");
    }
}
