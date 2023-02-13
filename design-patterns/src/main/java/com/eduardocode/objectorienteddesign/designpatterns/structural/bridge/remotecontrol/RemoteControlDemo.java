package com.eduardocode.objectorienteddesign.designpatterns.structural.bridge.remotecontrol;

public class RemoteControlDemo {

    public static void main(String[] args) {
        testDevice(new Tv());
        testDevice(new Radio());
    }

    public static void testDevice(Device device) {
        System.out.println("Test with basic remote");
        BasicRemoteControl basicRemote = new BasicRemoteControl(device);
        basicRemote.power();
        basicRemote.volumeDown();
        device.printStatus();

        System.out.println("Test with advanced remote");
        AdvancedRemoteControl advancedRemote = new AdvancedRemoteControl(device);
        advancedRemote.power();
        advancedRemote.mute();
        device.printStatus();

        advancedRemote.power();
        advancedRemote.channelDown();
        advancedRemote.channelDown();
        advancedRemote.mute();
        device.printStatus();
    }
}
