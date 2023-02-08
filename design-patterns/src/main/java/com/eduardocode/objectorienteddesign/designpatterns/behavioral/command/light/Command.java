package com.eduardocode.objectorienteddesign.designpatterns.behavioral.command.light;

public abstract class Command {
    private final Light light;

    public Command(Light light) {
        this.light = light;
    }

    abstract void execute();

    public Light getLight() {
        return light;
    }
}
