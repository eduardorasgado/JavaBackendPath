package com.eduardocode.demo;

import com.badlogic.gdx.math.Rectangle;

public class BucketControl implements Controllable {

    private final Rectangle bucket;

    private final ApplicationSettings applicationSettings;

    public BucketControl(Rectangle bucket, ApplicationSettings applicationSettings) {
        this.bucket = bucket;
        this.applicationSettings = applicationSettings;
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
}
