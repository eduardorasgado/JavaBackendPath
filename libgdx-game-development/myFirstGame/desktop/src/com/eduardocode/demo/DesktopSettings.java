package com.eduardocode.demo;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

public class DesktopSettings implements GameSettings
{
    private final String title;

    private final int height;

    private final int width;

    private final int fps;

    private boolean vsyncActive;

    public DesktopSettings(String title, int height, int width, int fps, boolean vsyncActive)
    {
        this.title = title;
        this.height = height;
        this.width = width;
        this.fps = fps;
        this.vsyncActive = vsyncActive;
    }

    private String getTitle()
    {
        return title;
    }

    @Override
    public int getHeight()
    {
        return height;
    }

    @Override
    public int getWidth()
    {
        return width;
    }

    private int getFps()
    {
        return fps;
    }

    private boolean isVsyncActive()
    {
        return vsyncActive;
    }

    public void configure(Lwjgl3ApplicationConfiguration config)
    {
        config.setTitle(getTitle());
        config.setWindowedMode(getHeight(), getWidth());
        config.useVsync(isVsyncActive());
        config.setForegroundFPS(getFps());
    }
}
