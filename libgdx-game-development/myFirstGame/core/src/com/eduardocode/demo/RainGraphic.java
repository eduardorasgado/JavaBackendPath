package com.eduardocode.demo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

public class RainGraphic implements Drawable
{

    private Array<Rectangle> raindrops;

    private final Texture dropImage;

    public RainGraphic(Array<Rectangle> raindrops, GameSettings gameSettings)
    {
        this.raindrops = raindrops;
        dropImage = new Texture(Gdx.files.internal(gameSettings.getAsset(GameSettings.SpriteAsset.DROP)));
    }

    @Override
    public void draw(SpriteBatch batch)
    {
        for (Rectangle raindrop : raindrops)
            batch.draw(dropImage, raindrop.x, raindrop.y, raindrop.width, raindrop.height);
    }

    @Override
    public void dispose() {
        dropImage.dispose();
    }
}
