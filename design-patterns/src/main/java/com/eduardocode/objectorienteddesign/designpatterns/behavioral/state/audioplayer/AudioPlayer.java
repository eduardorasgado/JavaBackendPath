package com.eduardocode.objectorienteddesign.designpatterns.behavioral.state.audioplayer;

public class AudioPlayer {

    private State state;
    private final Ui ui;
    private Volume volume;
    private final Playlist playlist;
    private Song currentSong;
    private boolean playing = false;

    public AudioPlayer(Ui ui) {
        this.ui = ui;
        state = new ReadyState(this);

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
        setPlaying(true);
        System.out.println("Playing " + currentSong.getName());
    }

    public void stopPlayback() {
        setPlaying(false);
        System.out.println("Stopping " + currentSong.getName());
    }

    public void nextSong() {
        currentSong = playlist.next();
        System.out.println("Moving to next song: " + currentSong.getName());
    }

    public void previousSong() {
        currentSong = playlist.prev();
        System.out.println("Moving to previous song: " + currentSong.getName());
    }

    public void fastForward(int timeInSecs) {
        System.out.println("Fast-forwarding " + currentSong.getName() + " time by " + timeInSecs + " secs.");
    }

    public void rewind(int timeInSecs) {
        System.out.println("Rewinding time " + currentSong.getName() + " by " + timeInSecs + " secs.");
    }

    public boolean isPlaying() {
        return playing;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public Ui getUi() {
        return ui;
    }
}