package com.eduardocode.demo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

public class RainGraphic implements RectangleDrawable
{

    private final Array<Rectangle> raindrops;

    private final Texture dropImage;

    private final ApplicationSettings applicationSettings;

    private final SpriteAsset asset;

    public RainGraphic(Array<Rectangle> raindrops, ApplicationSettings applicationSettings, SpriteAsset asset)
    {
        this.dropImage = new Texture(Gdx.files.internal(asset.path()));
        this.applicationSettings = applicationSettings;
        this.raindrops = raindrops;
        this.asset = asset;
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

    @Override
    public Rectangle create() {
        Rectangle raindrop = new Rectangle();

        raindrop.x = MathUtils.random(applicationSettings.getOriginWidth(), applicationSettings.getWidth() - 64);
        raindrop.y = applicationSettings.getHeight();
        raindrop.width = asset.width();
        raindrop.height = asset.height();

        return raindrop;
    }
}
