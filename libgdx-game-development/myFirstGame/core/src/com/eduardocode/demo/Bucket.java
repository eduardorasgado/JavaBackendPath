package com.eduardocode.demo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Bucket implements BatchDrawable, Controllable
{
    private final Rectangle bucket;

    private final Texture bucketImage;

    private ApplicationSettings applicationSettings;

    public Bucket(ApplicationSettings applicationSettings, GameSettings gameSettings)
    {
        this.applicationSettings = applicationSettings;

        bucketImage = new Texture(Gdx.files.internal(gameSettings.getAsset(GameSettings.SpriteAsset.BUCKET)));

        bucket = new Rectangle();
        bucket.x = applicationSettings.getWidth() / 2 - 64 / 2;
        bucket.y = 20;
        bucket.width = 64;
        bucket.height = 64;
    }

    @Override
    public void draw(SpriteBatch batch)
    {
        batch.draw(bucketImage, bucket.x, bucket.y, bucket.width, bucket.height);
    }

    @Override
    public void moveTo(float newPosition)
    {
        bucket.x = newPosition - 64 / 2;
        sanitizeNewPosition();
    }

    @Override
    public void moveLeft(float pixelsToMove)
    {
        bucket.x -= pixelsToMove;
        sanitizeNewPosition();
    }

    @Override
    public void moveRight(float pixelsToMove)
    {
        bucket.x += pixelsToMove;
        sanitizeNewPosition();
    }

    private void sanitizeNewPosition()
    {
        if(bucket.x < applicationSettings.getOriginWidth())
            bucket.x = applicationSettings.getOriginWidth();

        if(bucket.x + 64 > applicationSettings.getWidth())
            bucket.x = applicationSettings.getWidth() - 64;
    }

    public Rectangle getBucket()
    {
        return bucket;
    }

    public void dispose()
    {
        bucketImage.dispose();
    }

}
