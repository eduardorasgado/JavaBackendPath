package com.eduardocode.designpatterns.behavioral.state.audioplayer;

public class Button {
    private final String name;
    private Runnable onClickRunnable;

    public Button(String name) {
        this.name = name;
    }

    public void onClick(Runnable runnable) {
        onClickRunnable = runnable;
    }

    public void click() {
        onClickRunnable.run();
    }

    public String getName() {
        return name;
    }
}
