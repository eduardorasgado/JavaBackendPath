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

    private final GameSettings gameSettings;

    public MainMenuScreen(final Drop game, ApplicationSettings applicationSettings, GameSettings gameSettings)
    {
        this.game = game;
        this.gameSettings = gameSettings;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, applicationSettings.getWidth(), applicationSettings.getHeight());

        welcomeText = new ScreenText(gameSettings.getAsset(GameSettings.TextPlaceholderType.WELCOME_TO_DROP), 100, 150);
        game.assignFont(welcomeText);
        tapText = new ScreenText(gameSettings.getAsset(GameSettings.TextPlaceholderType.TAP_ANYWHERE_TO_BEGIN), 100, 100);
        game.assignFont(tapText);


        menuControl = new MenuControl(game, this, new GameScreen(game, applicationSettings, gameSettings));
    }

    @Override
    public void show()
    {
    }

    @Override
    public void render(float delta)
    {
        ScreenUtils.clear(
                gameSettings.getBackground(GameSettings.BackgroundItemType.RED),
                gameSettings.getBackground(GameSettings.BackgroundItemType.GREEN),
                gameSettings.getBackground(GameSettings.BackgroundItemType.BLUE),
                gameSettings.getBackground(GameSettings.BackgroundItemType.ALPHA));

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
