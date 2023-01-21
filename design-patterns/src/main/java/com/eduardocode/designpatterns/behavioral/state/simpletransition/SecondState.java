package com.eduardocode.designpatterns.behavioral.state.simpletransition;

public class SecondState extends BaseState {


    public SecondState() {
        super("Second State");
    }

    @Override
    public void doThis() {
        System.out.println("Second State is doing this...");
        getContext().setProperty("B");
    }

    @Override
    public void doThat() {
        System.out.println("Second state is doing that...");
        if(!getContext().getProperty().equals("B")) {
            System.out.println("Second state is doing something because prop is not B and is " + getContext().getProperty());
        } else {
            System.out.println("Second state is doing something because prop is B");
            getContext().setState(new FinalState());
        }
    }
}
