package com.eduardocode.demo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Bucket implements BatchDrawable
{
    private final Rectangle bucket;

    private final Texture bucketImage;

    private GameSettings gameSettings;

    public Bucket(GameSettings gameSettings)
    {
        this.gameSettings = gameSettings;

        bucketImage = new Texture(Gdx.files.internal("sprite/bucket.png"));

        bucket = new Rectangle();
        bucket.x = gameSettings.getWidth() / 2 - 64 / 2;
        bucket.y = 20;
        bucket.width = 64;
        bucket.height = 64;
    }

    @Override
    public void draw(SpriteBatch batch)
    {
        batch.draw(bucketImage, bucket.x, bucket.y, bucket.width, bucket.height);
    }

    public void moveTo(float newPosition)
    {
        bucket.x = newPosition - 64 / 2;
        sanitizeNewPosition();
    }

    public void moveLeft(float pixelsToMove)
    {
        bucket.x -= pixelsToMove;
    }

    public void moveRight(float pixelsToMove)
    {
        bucket.x += pixelsToMove;
    }

    private void sanitizeNewPosition()
    {
        if(bucket.x < gameSettings.getOriginWidth())
            bucket.x = gameSettings.getOriginWidth();

        if(bucket.x + 64 > gameSettings.getWidth())
            bucket.x = gameSettings.getWidth() - 64;
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
