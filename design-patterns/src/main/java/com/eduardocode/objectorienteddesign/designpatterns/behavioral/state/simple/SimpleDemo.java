package com.eduardocode.objectorienteddesign.designpatterns.behavioral.state.simple;

public class SimpleDemo {

    public static void main(String[] args) {
        Context context = new Context();

        State startState = new StartState();
        State stopState = new StopState();

        startState.doAction();
        context.setState(startState);

        stopState.doAction();
        context.setState(stopState);
    }
}
