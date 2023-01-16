package com.eduardocode.designpatterns.structural.adapter.mediaplayer;

public class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing MP4 file. Name: " + fileName);
    }

    @Override
    public void playVlc(String fileName) {
        //
    }
}
