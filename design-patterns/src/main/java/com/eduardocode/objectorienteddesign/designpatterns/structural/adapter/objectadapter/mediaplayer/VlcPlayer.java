package com.eduardocode.objectorienteddesign.designpatterns.structural.adapter.objectadapter.mediaplayer;

public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playMp4(String fileName) {
        //
        System.out.println("...");
    }

    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing VLC file. Name: " + fileName);
    }
}
