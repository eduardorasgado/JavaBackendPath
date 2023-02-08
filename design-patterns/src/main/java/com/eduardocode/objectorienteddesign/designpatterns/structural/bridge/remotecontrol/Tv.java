package com.eduardocode.objectorienteddesign.designpatterns.structural.bridge.remotecontrol;

public class Tv implements Device {
    boolean enabled;

    public Tv() {
        this.enabled = false;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void turnOn() {
        System.out.println("Tv is turning on....");
        setEnabled(true);
    }

    @Override
    public void turnOff() {
        System.out.println("Tv is turning off...");
        setEnabled(false);
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
