package com.eduardocode.designpatterns.behavioral.state.audioplayer;

public class LockedState extends State {
    public LockedState(AudioPlayer player) {
        super(player);
        getPlayer().getUi().update(this);
        System.out.println("Locked state...");
    }

    @Override
    void clickLock() {
        if(getPlayer().isPlaying()) {
            getPlayer().changeState(new PlayingState(getPlayer()));
        }
        else {
            getPlayer().changeState(new ReadyState(getPlayer()));
        }
    }

    @Override
    void clickPlay() {
        System.out.println("Player is locked...");
    }

    @Override
    void clickNext(ButtonAction event) {
        System.out.println("Player is locked...");
    }

    @Override
    void clickPrevious(ButtonAction event) {
        System.out.println("Player is locked...");
    }
}
