package com.eduardocode.objectorienteddesign.designpatterns.behavioral.command.light;

public class SimpleDemo {

    public static void main(String[] args) {
        Light light = new Light();
        Command lightOnCommand = new LightOnCommand(light);
        Command lightOffCommand = new LightOffCommand(light);

        RemoteControl remoteControl = new RemoteControl();

        remoteControl.setCommand(lightOnCommand);
        remoteControl.pressButton();

        remoteControl.setCommand(lightOffCommand);
        remoteControl.pressButton();

        Command goingUpIntensity = new RaiseIntensityCommand(light);
        Command goingDownIntensity = new LowerIntensityCommand(light);

        remoteControl.setCommand(goingDownIntensity);
        for (int i = 0; i < 11; i++) {
            remoteControl.pressButton();
        }

        remoteControl.setCommand(goingUpIntensity);
        remoteControl.pressButton();
        remoteControl.pressButton();
    }
}
