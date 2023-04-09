package com.eduardocode.demo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Bucket implements Drawable
{
    private final Rectangle bucket;
    private final RectangleDrawable graphics;

    private final Movabable controls;


    public Bucket(ApplicationSettings applicationSettings, GameSettings gameSettings)
    {
        SpriteAsset asset = gameSettings.getAsset(GameSettings.SpriteAssetType.BUCKET);
        graphics = new BucketGraphic(applicationSettings, asset);
        bucket = graphics.create();
        controls = new BucketControl(bucket, applicationSettings);
    }

    @Override
    public void draw(SpriteBatch batch)
    {
        graphics.draw(batch);
    }

    public Rectangle getBucket()
    {
        return bucket;
    }

    public void control(Controllable controllable) {
        controllable.control(controls);
    }

    public void dispose()
    {
        graphics.dispose();
    }
}
