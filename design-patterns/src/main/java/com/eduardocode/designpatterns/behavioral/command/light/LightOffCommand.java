package com.eduardocode.designpatterns.behavioral.command.light;

public class LightOffCommand extends Command {

    public LightOffCommand(Light light) {
        super(light);
    }

    @Override
    public void execute() {
        getLight().turnOff();
    }
}
