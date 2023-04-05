package com.eduardocode.demo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

public class MenuControl
{

    private final Drop game;
    private final Screen screen;

    private final ApplicationSettings applicationSettings;

    private final GameSettings gameSettings;

    public MenuControl(Drop game, Screen screen, ApplicationSettings applicationSettings, GameSettings gameSettings)
    {
        this.game = game;
        this.screen = screen;
        this.applicationSettings = applicationSettings;
        this.gameSettings = gameSettings;
    }

    public void control()
    {
        if(Gdx.input.isTouched())
        {
            game.setScreen(new GameScreen(game, applicationSettings, gameSettings));
            screen.dispose();
        }
    }
}
