package com.eduardocode.objectorienteddesign.designpatterns.behavioral.command.light;

public class LowerIntensityCommand extends Command {

    public LowerIntensityCommand(Light light) {
        super(light);
    }

    @Override
    public void execute() {
        getLight().lowerIntensity();
    }
}
