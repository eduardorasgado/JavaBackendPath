package com.eduardocode.demo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

public class MenuControl
{

    private final Drop game;
    private final Screen currentScreen;

    private final Screen nextScreen;

    public MenuControl(Drop game, Screen screen, Screen nextScreen)
    {
        this.game = game;
        this.currentScreen = screen;
        this.nextScreen = nextScreen;
    }

    public void control()
    {
        if(Gdx.input.isTouched())
        {
            game.setScreen(nextScreen);
            currentScreen.dispose();
        }
    }
}
