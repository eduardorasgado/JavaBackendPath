package com.eduardocode.designpatterns.behavioral.state.simpletransition;

public interface Context {

    void setState(State state);

    void doSomething(String name);

    String getProperty();
    void setProperty(String property);
}
