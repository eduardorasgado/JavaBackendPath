package com.eduardocode.demo;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public interface Drawable
{
    void draw(SpriteBatch batch);

    void dispose();
}
