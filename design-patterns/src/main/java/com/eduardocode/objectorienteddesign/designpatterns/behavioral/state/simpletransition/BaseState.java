package com.eduardocode.objectorienteddesign.designpatterns.behavioral.state.simpletransition;

public abstract class BaseState implements State {
    private String name;
    private Context context;

    public BaseState(String name) {
        this.name = name;
    }

    @Override
    public Context getContext() {
        return context;
    }

    @Override
    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public String getName() {
        return name;
    }
}
