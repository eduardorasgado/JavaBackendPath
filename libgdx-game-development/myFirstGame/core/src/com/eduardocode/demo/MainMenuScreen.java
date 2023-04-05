package com.eduardocode.demo;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;

public class MainMenuScreen implements Screen
{

    private final Drop game;
    private final OrthographicCamera camera;

    private final ScreenText welcomeText;

    private final ScreenText tapText;

    private final MenuControl menuControl;

    public MainMenuScreen(final Drop game, ApplicationSettings applicationSettings, GameSettings gameSettings)
    {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, applicationSettings.getWidth(), applicationSettings.getHeight());

        welcomeText = new ScreenText("Welcome to Drop!!! ", 100, 150);
        game.assignFont(welcomeText);
        tapText = new ScreenText("Tap anywhere to begin!", 100, 100);
        game.assignFont(tapText);

        menuControl = new MenuControl(game, this, applicationSettings, gameSettings);
    }

    @Override
    public void show()
    {
    }

    @Override
    public void render(float delta)
    {
        ScreenUtils.clear(0, 0, 0.2f, 1);

        game.setBatchProjectionMatrix(camera);

        game.drawInBatch(welcomeText, tapText);

        menuControl.control();

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
