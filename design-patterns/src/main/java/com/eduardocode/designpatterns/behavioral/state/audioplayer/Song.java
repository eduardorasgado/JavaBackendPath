package com.eduardocode.designpatterns.behavioral.state.audioplayer;

public class Song {
    String name;

    public Song(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
