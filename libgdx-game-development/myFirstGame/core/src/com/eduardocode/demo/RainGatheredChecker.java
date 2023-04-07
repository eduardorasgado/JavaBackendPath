package com.eduardocode.demo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Rectangle;

import java.util.Iterator;

public class RainGatheredChecker
{
    private final RainPlayer sounds;

    public RainGatheredChecker(GameSettings gameSettings)
    {
        sounds = new RainPlayer(gameSettings);
    }

    public int checkForRaindrops(Rain rain, Bucket bucket)
    {
        int dropsGathered = 0;

        dropsGathered = gatherRaindrops(rain, bucket);
        sounds.triggerDropSound(dropsGathered);

        return dropsGathered;
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
        sounds.dispose();
    }
}
