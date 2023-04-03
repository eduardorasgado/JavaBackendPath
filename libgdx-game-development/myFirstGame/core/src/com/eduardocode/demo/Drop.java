package com.eduardocode.demo;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Drop extends Game
{

    public SpriteBatch batch;
    public BitmapFont font;

    @Override
    public void create()
    {
        batch = new SpriteBatch(100);
        font = new BitmapFont();
        setScreen(new MainMenuScreen(this));
    }

    @Override
    public void render()
    {
        super.render();
    }

    @Override
    public void dispose()
    {
        batch.dispose();
        font.dispose();
        getScreen().dispose();
    }
}
