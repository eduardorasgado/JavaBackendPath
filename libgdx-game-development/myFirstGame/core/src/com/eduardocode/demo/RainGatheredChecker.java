package com.eduardocode.demo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Rectangle;

import java.util.Iterator;

public class RainGatheredChecker
{

    private final Sound dropSound;

    public RainGatheredChecker(GameSettings gameSettings)
    {
        dropSound = Gdx.audio.newSound(Gdx.files.internal(gameSettings.getAsset(GameSettings.SoundAsset.DROP)));
    }

    public int checkForRaindrops(Rain rain, Bucket bucket)
    {
        int dropsGathered = 0;

        dropsGathered = gatherRaindrops(rain, bucket);
        triggerDropSound(dropsGathered);

        return dropsGathered;
    }

    private void triggerDropSound(int dropsGathered) {
        for (int i = 0; i < dropsGathered; i++) {
            dropSound.play();
        }
    }

    public int gatherRaindrops(Rain rain, Bucket bucket)
    {
        int dropsGathered = 0;
        for (Iterator<Rectangle> iterator = rain.getRaindrops().iterator(); iterator.hasNext(); )
        {
            Rectangle raindrop = iterator.next();

            if(raindrop.overlaps(bucket.getBucket()))
            {
                iterator.remove();
                ++dropsGathered;
            }
        }

        return dropsGathered;
    }

    public void dispose()
    {
        dropSound.dispose();
    }
}
