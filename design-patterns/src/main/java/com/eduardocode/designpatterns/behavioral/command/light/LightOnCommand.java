package com.eduardocode.designpatterns.behavioral.command.light;

public class LightOnCommand extends Command {

    public LightOnCommand(Light light) {
        super(light);
    }

    @Override
    public void execute() {
        getLight().turnOn();
    }
}
