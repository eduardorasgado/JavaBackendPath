package com.eduardocode.designpatterns.behavioral.state.audioplayer;

public class Ui {
    public Button lockButton;
    public Button playButton;
    public Button nextButton;
    public Button prevButton;

    public Ui(Button lockButton, Button playButton, Button nextButton, Button prevButton) {
        this.lockButton = lockButton;
        this.playButton = playButton;
        this.nextButton = nextButton;
        this.prevButton = prevButton;
    }

    public void init(State state) {
        lockButton.onClick(state::clickLock);
        playButton.onClick(state::clickPlay);
        playButton.onClick(state::clickNext);
        playButton.onClick(state::clickPrevious);
    }
}
