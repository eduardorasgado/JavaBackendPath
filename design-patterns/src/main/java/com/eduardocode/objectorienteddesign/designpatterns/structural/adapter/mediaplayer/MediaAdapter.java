package com.eduardocode.objectorienteddesign.designpatterns.structural.adapter.mediaplayer;

/*
* MediaAdapter is the adapter that is used to play mp4 and vlc media types(incompatible interfaces)
* AdvancedMediaPlayer is the adaptee or the incompatible vendor MediaAdapter will adapt to MediaPlayer target interface
 */
public class MediaAdapter implements MediaPlayer {
    private AdvancedMediaPlayer advancedAudioPlayer;
    private final MediaType mediaType;

    public MediaAdapter(MediaType mediaType) {
        System.out.println("New Media adapter is created...");

        if(mediaType.equals(MediaType.MP4)) {
            advancedAudioPlayer = new Mp4Player();
        }
        else if(mediaType.equals(MediaType.VLC)) {
            advancedAudioPlayer = new VlcPlayer();
        }

        this.mediaType = mediaType;
    }

    @Override
    public void play(MediaType mediaType, String fileName) {
        if(mediaType.equals(MediaType.MP4)) {
            advancedAudioPlayer.playMp4(fileName);
        }
        else if(mediaType.equals(MediaType.VLC)) {
            advancedAudioPlayer.playVlc(fileName);
        }
    }

    public MediaType getMediaType() {
        return mediaType;
    }
}
