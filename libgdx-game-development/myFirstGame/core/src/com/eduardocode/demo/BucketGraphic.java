package com.eduardocode.demo;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class BucketGraphic implements Drawable
{
    private final Rectangle bucket;

    private final Texture bucketImage;

    public BucketGraphic(Rectangle bucket, Texture bucketImage) {
        this.bucket = bucket;
        this.bucketImage = bucketImage;
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(bucketImage, bucket.x, bucket.y, bucket.width, bucket.height);
    }

    @Override
    public void dispose() {
        bucketImage.dispose();
    }
}
