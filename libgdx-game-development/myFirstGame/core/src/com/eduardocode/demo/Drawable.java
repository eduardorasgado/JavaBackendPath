package com.eduardocode.demo;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface Drawable {
    void draw(SpriteBatch batch);

    void dispose();
}
