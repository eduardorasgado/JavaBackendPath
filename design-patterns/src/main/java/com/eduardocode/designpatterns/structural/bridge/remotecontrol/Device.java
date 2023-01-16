package com.eduardocode.designpatterns.structural.bridge.remotecontrol;

public interface Device {
    boolean isEnabled();
    void turnOn();
    void turnOff();
}
