package com.eduardocode.designpatterns.behavioral.command.light;

public class RaiseIntensityCommand extends Command {

    public RaiseIntensityCommand(Light light) {
        super(light);
    }

    @Override
    public void execute() {
        getLight().raiseIntensity();
    }
}
