package com.eduardocode.demo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;

public class MainMenuScreen implements Screen
{

    private final Drop game;
    private final OrthographicCamera camera;

    private final GameSettings gameSettings;

    public MainMenuScreen(final Drop game, GameSettings gameSettings)
    {
        this.game = game;
        this.gameSettings = gameSettings;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, gameSettings.getWidth(), gameSettings.getHeight());
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);

        game.setBatchProjectionMatrix(camera);

        game.drawInBatch(() ->
        {
            game.font.draw(game.batch, "Welcome to Drop!!! ", 100, 150);
            game.font.draw(game.batch, "Tap anywhere to begin!", 100, 100);
        });

        if(Gdx.input.isTouched())
        {
            game.setScreen(new GameScreen(game, gameSettings));
            dispose();
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
    }
}
