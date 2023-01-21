package com.eduardocode.designpatterns.behavioral.state.audioplayer;

public class AudioPlayerDemo {

    public static void main(String[] args) {
        Button lockButton = new Button("Lock");
        Button playButton = new Button("Play");
        Button nextButton = new Button("Next");
        Button prevButton = new Button("Prev");

        Ui ui = new Ui(lockButton, playButton, nextButton, prevButton);
        AudioPlayer player = new AudioPlayer(ui);
    }
}
