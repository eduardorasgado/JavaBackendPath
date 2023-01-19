package com.eduardocode.designpatterns.behavioral.command.light;

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
        remoteControl.pressButton();
        remoteControl.pressButton();
        remoteControl.pressButton();
        remoteControl.pressButton();

        remoteControl.setCommand(goingUpIntensity);
        remoteControl.pressButton();
        remoteControl.pressButton();
    }
}
