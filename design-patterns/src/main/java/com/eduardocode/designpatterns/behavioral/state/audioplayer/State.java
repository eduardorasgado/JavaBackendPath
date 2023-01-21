package com.eduardocode.designpatterns.behavioral.state.audioplayer;

public abstract class State {
    protected AudioPlayer player;

    public State(AudioPlayer player) {
        this.player = player;
    }

    abstract void clickLock();
    abstract void clickPlay();
    abstract void clickNext();
    abstract void clickPrevious();
}
