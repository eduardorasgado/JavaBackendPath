package com.eduardocode.designpatterns.behavioral.state.audioplayer;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private List<Song> content;
    private int currentSongIndex;

    public Playlist() {
        this.content = new ArrayList<>();
    }

    public void add(Song song) {
        content.add(song);
    }

    public Song getCurrent() {
        return get(currentSongIndex);
    }

    public Song next() {
        currentSongIndex = (currentSongIndex + 1) % content.size();
        return get(currentSongIndex);
    }

    private Song get(int index) {
        if(index < content.size()) {
            return content.get(index);
        }
        return null;
    }

    public Song prev() {
        currentSongIndex = (((currentSongIndex - 1) < 0) ? content.size() : currentSongIndex) - 1;
        return get(currentSongIndex);
    }

    public static void main(String[] args) {
        int currentSongIndex = 2;
        System.out.println(currentSongIndex);

        currentSongIndex = ((currentSongIndex - 1) < 0) ? 5 : (currentSongIndex - 1);
        System.out.println(currentSongIndex);

        currentSongIndex = ((currentSongIndex - 1) < 0) ? 5 : (currentSongIndex - 1);
        System.out.println(currentSongIndex);

        currentSongIndex = ((currentSongIndex - 1) < 0) ? 5 : (currentSongIndex - 1);
        System.out.println(currentSongIndex);

        currentSongIndex = ((currentSongIndex - 1) < 0) ? 5 : (currentSongIndex - 1);
        System.out.println(currentSongIndex);
    }
}
