package com.eduardocode.designpatterns.behavioral.state.audioplayer;

public class AudioPlayerDemo {

    public static void main(String[] args) {
        BasicButton lockButton = new BasicButton("Lock");
        BasicButton playButton = new BasicButton("Play");
        AdvancedButton nextButton = new AdvancedButton("Next");
        AdvancedButton prevButton = new AdvancedButton("Prev");

        Ui ui = new Ui(lockButton, playButton, nextButton, prevButton);
        AudioPlayer player = new AudioPlayer(ui);

        player.addSongToPlaylist(new Song("Song A"));
        player.addSongToPlaylist(new Song("Song B"));
        player.addSongToPlaylist(new Song("Song C"));
        player.addSongToPlaylist(new Song("Song D"));

        Ui playerUi = player.getUi();
        playerUi.lockButton.click();
        playerUi.playButton.click();

        playerUi.lockButton.click();
        playerUi.playButton.click();

        playerUi.nextButton.click();
        playerUi.nextButton.doubleClick();
        playerUi.nextButton.doubleClick();

        playerUi.prevButton.click();
        playerUi.prevButton.doubleClick();
        playerUi.prevButton.doubleClick();
        playerUi.prevButton.doubleClick();
        playerUi.prevButton.doubleClick();

        playerUi.nextButton.doubleClick();
        playerUi.nextButton.doubleClick();
        playerUi.nextButton.doubleClick();

        playerUi.playButton.click();

        playerUi.lockButton.click();
        playerUi.playButton.click();
    }
}
