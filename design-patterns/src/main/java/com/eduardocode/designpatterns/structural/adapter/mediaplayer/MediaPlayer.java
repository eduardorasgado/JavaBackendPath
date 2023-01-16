package com.eduardocode.designpatterns.structural.adapter.mediaplayer;

/*
* This is the Target interface
 */
public interface MediaPlayer {
    void play(MediaType audioType, String fileName);
}
