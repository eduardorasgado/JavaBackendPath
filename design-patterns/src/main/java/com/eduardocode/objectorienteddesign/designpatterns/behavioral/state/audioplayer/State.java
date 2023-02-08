package com.eduardocode.objectorienteddesign.designpatterns.behavioral.state.audioplayer;

public abstract class State {
    private final AudioPlayer player;

    public State(AudioPlayer player) {
        this.player = player;
    }

    public AudioPlayer getPlayer() {
        return player;
    }

    abstract void clickLock();
    abstract void clickPlay();
    abstract void clickNext(ButtonAction event);
    abstract void clickPrevious(ButtonAction event);
}
