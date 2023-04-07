package com.eduardocode.demo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.Iterator;

public class Rain implements Drawable
{
    private Drawable graphics;

    private final Array<Rectangle> raindrops;

    private RainControl rainControl;

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

        graphics = new RainGraphic(raindrops, gameSettings);
        rainControl = new RainControl(raindrops, applicationSettings);

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
        graphics.draw(batch);
    }

    public boolean canSpawnRaindrop()
    {
        return TimeUtils.nanoTime() - lastDropTime > maxTimeInNanos;
    }

    public void moveDown(float pixelsToMove)
    {
        rainControl.moveDown(pixelsToMove);
    }

    public Array<Rectangle> getRaindrops() {
        return raindrops;
    }

    public void dispose()
    {
        graphics.dispose();
    }
}
