package com.eduardocode.designpatterns.structural.bridge.remotecontrol;

public class AdvancedRemoteControl extends RemoteControl {

    public AdvancedRemoteControl(Device device) {
        super(device);
    }

    @Override
    public void togglePower() {
        if(device.isEnabled()) {
           device.turnOff();
        }
        else {
            device.turnOn();
        }
    }
}
