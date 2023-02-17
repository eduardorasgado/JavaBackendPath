package com.eduardocode.objectorienteddesign.designpatterns.behavioral.mediator.tv;

public class Tv {
    private boolean on;

    private Mediator mediator;

    public Tv(Mediator mediator) {
        this.mediator = mediator;
    }

    public void turnOff() {
        mediator.stop();
        setOn(false);
    }

    public void turnOn() {
        mediator.start();
        setOn(true);
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }
}
