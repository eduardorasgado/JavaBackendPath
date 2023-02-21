package com.eduardocode.objectorienteddesign.designpatterns.structural.adapter.objectadapter.mediaplayer;

public class MediaPlayerDemo {

    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play(MediaType.MP3, "beyond the horizon.mp3");
        audioPlayer.play(MediaType.MP4, "home alone.mp4");
        audioPlayer.play(MediaType.MP4, "playing god - polyphia.mp4");
        audioPlayer.play(MediaType.VLC, "Mr robot 01x02.vlc");
        audioPlayer.play(MediaType.VLC, "Mr robot 02x02.vlc");
        audioPlayer.play(MediaType.MP4, "bloodbath - polyphia ft chino.mp4");
        audioPlayer.play(MediaType.VLC, "Mr robot 03x02.vlc");
        audioPlayer.play(MediaType.AVI, "mind me.avi");
    }
}
