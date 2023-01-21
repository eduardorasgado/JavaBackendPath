package com.eduardocode.designpatterns.behavioral.state.simpletransition;

public class ConcreteContext implements Context {
    private State currentState;
    private String prop;

    public ConcreteContext(State currentState) {
        this.currentState = currentState;
        currentState.setContext(this);
        prop = "A";
    }

    public void showInformation() {
        System.out.println("Curr state: " + currentState.getName());
    }

    public void doThis() {
        currentState.doThis();
    }

    public void doThat() {
        currentState.doThat();
    }

    @Override
    public void setState(State state) {
        currentState = state;
        currentState.setContext(this);
    }

    @Override
    public void doSomething(String name) {
        System.out.println("Concrete context is doing something with " + name);
    }

    @Override
    public String getProperty() {
        return prop;
    }

    @Override
    public void setProperty(String property) {
        prop = property;
    }


}
