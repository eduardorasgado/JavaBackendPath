package com.eduardocode.objectorienteddesign.designpatterns.behavioral.state.simpletransition;

public class FirstState extends BaseState {

    public FirstState() {
        super("Initial State");
    }

    @Override
    public void doThis() {
        getContext().doSomething(getName());
        System.out.println(getName() + " is doing this with context prop: " + getContext().getProperty());
    }

    @Override
    public void doThat() {
        System.out.println(getName() + " is doing something right before setting a new state to Context");
        getContext().setState(new SecondState());
    }
}
