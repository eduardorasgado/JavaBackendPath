package com.eduardocode.objectorienteddesign.designpatterns.behavioral.state.audioplayer;

public class PlayingState extends State {
    public PlayingState(AudioPlayer player) {
        super(player);
        getPlayer().getUi().update(this);
        System.out.println("Playing state...");
    }

    @Override
    void clickLock() {
        getPlayer().changeState(new LockedState(getPlayer()));
    }

    @Override
    void clickPlay() {
        getPlayer().stopPlayback();
        getPlayer().changeState(new ReadyState(getPlayer()));
    }

    @Override
    void clickNext(ButtonAction event) {
        if(event.equals(ButtonAction.DOUBLE_CLICK)) {
            getPlayer().nextSong();
        }
        else if(event.equals(ButtonAction.CLICK)) {
            getPlayer().fastForward(5);
        }
    }

    @Override
    void clickPrevious(ButtonAction event) {
        if(event.equals(ButtonAction.DOUBLE_CLICK)) {
            getPlayer().previousSong();
        }
        else if(event.equals(ButtonAction.CLICK)) {
            getPlayer().rewind(5);
        }
    }
}
