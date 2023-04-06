package com.eduardocode.demo;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Drop extends Game
{

    public SpriteBatch batch;
    public BitmapFont font;

    private final ApplicationSettings applicationSettings;
    private final GameSettings gameSettings;

    public Drop(ApplicationSettings applicationSettings, GameSettings gameSettings) {
        this.applicationSettings = applicationSettings;
        this.gameSettings = gameSettings;
    }

    @Override
    public void create()
    {
        int spriteBatchSize = 100;
        batch = new SpriteBatch(spriteBatchSize);
        font = new BitmapFont();

        setScreen(new MainMenuScreen(this, applicationSettings, gameSettings));
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

    void drawInBatch(Drawable... drawableList)
    {
        batch.begin();
        for (Drawable drawable : drawableList) {
            drawable.draw(batch);
        }
        batch.end();
    }

    public void assignFont(FontAssignable fontAssignable) {
        fontAssignable.setFont(font);
    }
}
