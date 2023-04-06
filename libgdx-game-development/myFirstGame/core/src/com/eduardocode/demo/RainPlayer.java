package com.eduardocode.demo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class RainPlayer
{
    private final Sound dropSound;

    public RainPlayer(GameSettings gameSettings)
    {
        this.dropSound = Gdx.audio.newSound(Gdx.files.internal(gameSettings.getAsset(GameSettings.SoundAsset.DROP)));
    }

    public void triggerDropSound(int times)
    {
        for (int i = 0; i < times; i++) {
            dropSound.play();
        }
    }

    public void dispose()
    {
        dropSound.dispose();
    }
}
