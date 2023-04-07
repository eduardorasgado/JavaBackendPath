package com.eduardocode.demo;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

import java.util.Iterator;
public class RainControl
{
    private final Array<Rectangle> raindrops;

    private final ApplicationSettings applicationSettings;

    public RainControl(Array<Rectangle> raindrops, ApplicationSettings applicationSettings) {
        this.raindrops = raindrops;
        this.applicationSettings = applicationSettings;
    }

    public void moveDown(float pixelsToMove)
    {
        for (Iterator<Rectangle> iterator = raindrops.iterator(); iterator.hasNext(); )
        {
            Rectangle raindrop = iterator.next();
            raindrop.y -= pixelsToMove;
        }
        sanitizeRaindrops();
    }

    private void sanitizeRaindrops() {
        for (Iterator<Rectangle> iterator = raindrops.iterator(); iterator.hasNext(); )
        {
            Rectangle raindrop = iterator.next();
            if (raindrop.y + 64 < applicationSettings.getOriginHeight()) iterator.remove();
        }
    }
}
