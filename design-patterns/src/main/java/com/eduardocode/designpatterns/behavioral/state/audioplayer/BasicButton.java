package com.eduardocode.designpatterns.behavioral.state.audioplayer;

public class BasicButton {
    protected Runnable onClickRunnable;
    private final String name;

    public BasicButton(String name) {
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
