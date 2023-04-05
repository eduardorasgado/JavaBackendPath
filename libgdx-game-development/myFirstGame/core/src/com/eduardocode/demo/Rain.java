package com.eduardocode.demo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.Iterator;

public class Rain implements BatchDrawable
{
    private final Texture dropImage;

    private final Sound dropSound;

    private final Array<Rectangle> raindrops;

    private long lastDropTime;

    private final long maxTimeInNanos;

    private final ApplicationSettings applicationSettings;

    private final GameSettings gameSettings;

    public Rain(ApplicationSettings applicationSettings, long maxTimeInNanos, GameSettings gameSettings)
    {
        this.applicationSettings = applicationSettings;
        this.maxTimeInNanos = maxTimeInNanos;
        this.gameSettings = gameSettings;

        raindrops = new Array<>();
        dropImage = new Texture(Gdx.files.internal(gameSettings.getAsset(GameSettings.SpriteAsset.DROP)));
        dropSound = Gdx.audio.newSound(Gdx.files.internal(gameSettings.getAsset(GameSettings.SoundAsset.DROP)));

        spawnRaindrop();
    }

    public void spawnRaindrop()
    {
        Rectangle raindrop = new Rectangle();

        raindrop.x = MathUtils.random(applicationSettings.getOriginWidth(), applicationSettings.getWidth() - 64);
        raindrop.y = applicationSettings.getHeight();
        raindrop.width = 64;
        raindrop.height = 64;
        raindrops.add(raindrop);

        lastDropTime = TimeUtils.nanoTime();
    }

    @Override
    public void draw(SpriteBatch batch)
    {
        for (Rectangle raindrop : raindrops)
            batch.draw(dropImage, raindrop.x, raindrop.y, raindrop.width, raindrop.height);
    }

    public boolean canSpawnRaindrop()
    {
        return TimeUtils.nanoTime() - lastDropTime > maxTimeInNanos;
    }

    public void moveDown(float pixelsToMove)
    {
        for (Iterator<Rectangle> iterator = raindrops.iterator(); iterator.hasNext(); )
        {
            Rectangle raindrop = iterator.next();
            raindrop.y -= pixelsToMove;
        }
        sanitizeRaindrops();
    }

    private void sanitizeRaindrops() {
        for (Iterator<Rectangle> iterator = raindrops.iterator(); iterator.hasNext(); )
        {
            Rectangle raindrop = iterator.next();
            if (raindrop.y + 64 < applicationSettings.getOriginHeight()) iterator.remove();
        }
    }

    public int gatherRaindrops(Bucket bucket) {
        int dropsGathered = 0;
        for (Iterator<Rectangle> iterator = raindrops.iterator(); iterator.hasNext(); )
        {
            Rectangle raindrop = iterator.next();
            if(raindrop.overlaps(bucket.getBucket()))
            {
                dropSound.play();
                iterator.remove();
                ++dropsGathered;
            }
        }

        return dropsGathered;
    }

    public void dispose()
    {
        dropImage.dispose();
        dropSound.dispose();
    }
}
