package com.eduardocode.objectorienteddesign.designpatterns.behavioral.state.simpletransition;

public interface State {

    void doThis();

    void doThat();

    Context getContext();

    void setContext(Context context);

    String getName();
}
