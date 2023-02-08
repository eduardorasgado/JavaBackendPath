package com.eduardocode.objectorienteddesign.designpatterns.behavioral.state.audioplayer;

public class ReadyState extends State {
    public ReadyState(AudioPlayer audioPlayer) {
        super(audioPlayer);
        getPlayer().getUi().update(this);
        System.out.println("Stand by or ready to play state...");
    }

    @Override
    void clickLock() {
        getPlayer().changeState(new LockedState(getPlayer()));
    }

    @Override
    void clickPlay() {
        getPlayer().changeState(new PlayingState(getPlayer()));
        getPlayer().startPlayBack();
    }

    @Override
    void clickNext(ButtonAction event) {
        getPlayer().nextSong();
    }

    @Override
    void clickPrevious(ButtonAction event) {
        getPlayer().previousSong();
    }
}
