package com.eduardocode.designpatterns.structural.adapter.mediaplayer;

// audio player is the client that uses the target interface
public class AudioPlayer implements MediaPlayer {
    private MediaAdapter mediaAdapter;

    @Override
    public void play(MediaType audioType, String fileName) {
        if(audioType.equals(MediaType.MP3)) {
            System.out.println("Playing mp3 file. Name: " + fileName);
        }
        else if(audioType.equals(MediaType.VLC) || audioType.equals(MediaType.MP4)) {
            if(mediaAdapter == null || !mediaAdapter.getMediaType().equals(audioType)) {
                mediaAdapter = new MediaAdapter(audioType);
            }

            mediaAdapter.play(audioType, fileName);
        }
        else {
            System.out.println("Invalid media. " + audioType + " format not supported");
        }
    }
}
