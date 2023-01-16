package com.eduardocode.designpatterns.structural.bridge.remotecontrol;

public abstract class RemoteControl {
    protected Device device;

    public RemoteControl(Device device) {
        this.device = device;
    }

    public abstract void togglePower();
}
