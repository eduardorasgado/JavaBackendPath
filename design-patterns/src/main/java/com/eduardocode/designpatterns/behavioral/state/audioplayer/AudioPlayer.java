package com.eduardocode.designpatterns.behavioral.state.audioplayer;

public class AudioPlayer {

    private State state;
    private Ui ui;
    private Volume volume;
    private Playlist playlist;
    private Song currentSong;

    public AudioPlayer(Ui ui) {
        state = new ReadyState(this);

        this.ui = ui;
        ui.init(state);

        volume = new Volume(100);
        playlist = new Playlist();
    }

    public void addSongToPlaylist(Song song) {
        playlist.add(song);
    }

    public void changeState(State state) {
        this.state = state;
    }

    public void startPlayBack() {
        currentSong = playlist.getCurrent();
        System.out.println("Playing " + currentSong.getName());
    }

    public void stopPlayback() {
        System.out.println("Stopping " + currentSong.getName());
    }

    public void nextSong() {
        currentSong = playlist.next();
        System.out.println("Moving to next song: " + currentSong);
    }
}