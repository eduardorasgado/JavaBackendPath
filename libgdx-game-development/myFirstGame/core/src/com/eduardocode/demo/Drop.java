package com.eduardocode.demo;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.List;
import java.util.function.Consumer;

public class Drop extends Game
{

    public SpriteBatch batch;
    public BitmapFont font;

    private final GameSettings gameSettings;


    public Drop(GameSettings gameSettings) {
        this.gameSettings = gameSettings;
    }

    @Override
    public void create()
    {
        int spriteBatchSize = 100;
        batch = new SpriteBatch(spriteBatchSize);
        font = new BitmapFont();

        setScreen(new MainMenuScreen(this, gameSettings));
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

    void setBatchProjectionMatrix(OrthographicCamera camera)
    {
        batch.setProjectionMatrix(camera.combined);
    }

    void drawInBatch(Runnable runnable)
    {
        batch.begin();
//        for (BatchDrawable drawable : drawableList) {
//            drawable.draw(batch);
//        }
        runnable.run();
        batch.end();
    }
}
