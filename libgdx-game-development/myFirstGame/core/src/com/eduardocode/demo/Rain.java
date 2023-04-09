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
    private final RectangleDrawable graphics;

    private final Array<Rectangle> raindrops;

    private RainControl rainControl;

    private long lastDropTime;

    private final long maxTimeInNanos;

    public Rain(ApplicationSettings applicationSettings, long maxTimeInNanos, GameSettings gameSettings)
    {
        this.maxTimeInNanos = maxTimeInNanos;

        raindrops = new Array<>();

        SpriteAsset rainAsset = gameSettings.getAsset(GameSettings.SpriteAssetType.DROP);
        graphics = new RainGraphic(raindrops, applicationSettings, rainAsset);
        rainControl = new RainControl(raindrops, applicationSettings);

        spawnRaindrop();
    }

    public void spawnRaindrop()
    {
        Rectangle raindrop = graphics.create();
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
