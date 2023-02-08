package com.eduardocode.objectorienteddesign.designpatterns.behavioral.state.audioplayer;

public class Ui {
    public BasicButton lockButton;
    public BasicButton playButton;
    public AdvancedButton nextButton;
    public AdvancedButton prevButton;

    public Ui(BasicButton lockButton, BasicButton playButton, AdvancedButton nextButton, AdvancedButton prevButton) {
        this.lockButton = lockButton;
        this.playButton = playButton;
        this.nextButton = nextButton;
        this.prevButton = prevButton;
    }

    public void update(State state) {
        lockButton.onClick(state::clickLock);
        playButton.onClick(state::clickPlay);

        nextButton.onClick(state::clickNext);
        prevButton.onClick(state::clickPrevious);
        nextButton.onDoubleClick(state::clickNext);
        prevButton.onDoubleClick(state::clickPrevious);

    }
}
