package com.eduardocode.objectorienteddesign.designpatterns.behavioral.mediator.tv;

public class Mediator {
    private Tv tv;
    private Display display;

    public Mediator() {
    }

    public void press() {
        if(tv.isOn()) {
            tv.turnOff();
        }
        else {
            tv.turnOn();
        }
    }

    public void start() {
        display.turnOn();
    }

    public void stop() {
        display.turnOff();
    }

    public void setTv(Tv tv) {
        this.tv = tv;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }
}
