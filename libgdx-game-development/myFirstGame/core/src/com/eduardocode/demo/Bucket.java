package com.eduardocode.demo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Bucket implements Drawable
{
    private final Rectangle bucket;
    private final Drawable graphics;

    private final Controllable controls;


    public Bucket(ApplicationSettings applicationSettings, GameSettings gameSettings)
    {
        bucket = new Rectangle();
        bucket.x = applicationSettings.getWidth() / 2 - 64 / 2;
        bucket.y = 20;
        bucket.width = 64;
        bucket.height = 64;

        Texture texture = new Texture(Gdx.files.internal(gameSettings.getAsset(GameSettings.SpriteAsset.BUCKET)));
        graphics = new BucketGraphic(bucket, texture);

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

    public Controllable getControls() {
        return controls;
    }

    public void dispose()
    {
        graphics.dispose();
    }
}
