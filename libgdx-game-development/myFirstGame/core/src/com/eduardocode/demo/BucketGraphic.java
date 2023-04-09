package com.eduardocode.demo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class BucketGraphic implements RectangleDrawable
{
    private final int displacementeInYAxis = 20;
    private Rectangle bucket;

    private final Texture bucketImage;

    private SpriteAsset asset;

    private final ApplicationSettings applicationSettings;

    public BucketGraphic(ApplicationSettings applicationSettings, SpriteAsset asset) {
        this.bucketImage = new Texture(Gdx.files.internal(asset.path()));
        this.applicationSettings = applicationSettings;
        this.asset = asset;
    }

    @Override
    public void draw(SpriteBatch batch)
    {
        batch.draw(bucketImage, bucket.x, bucket.y, bucket.width, bucket.height);
    }

    @Override
    public void dispose()
    {
        bucketImage.dispose();
    }

    @Override
    public Rectangle create() {
        bucket = new Rectangle();
        bucket.x = applicationSettings.centerByWidth(asset.width(), applicationSettings.getWidth());
        bucket.y = displacementeInYAxis;
        bucket.width = asset.width();
        bucket.height = asset.height();

        return bucket;
    }
}
