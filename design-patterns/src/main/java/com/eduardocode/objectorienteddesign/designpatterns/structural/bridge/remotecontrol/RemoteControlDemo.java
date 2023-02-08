package com.eduardocode.objectorienteddesign.designpatterns.structural.bridge.remotecontrol;

public class RemoteControlDemo {

    public static void main(String[] args) {
        Device myTv = new Tv();
        RemoteControl remoteControl = new AdvancedRemoteControl(myTv);
        remoteControl.togglePower();
        remoteControl.togglePower();
        remoteControl.togglePower();
        remoteControl.togglePower();
    }
}
