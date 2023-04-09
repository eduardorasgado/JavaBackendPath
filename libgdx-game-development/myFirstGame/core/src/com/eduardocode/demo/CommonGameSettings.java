package com.eduardocode.demo;

public abstract class CommonGameSettings implements GameSettings
{
    private final float[] backgroundItems;

    private long gameTimeInterval;

    public CommonGameSettings()
    {
        gameTimeInterval = 0;
        backgroundItems = new float[4];
    }

    @Override
    public void setBackground(float red, float green, float blue, float alpha)
    {
        backgroundItems[BackgroundItemType.RED.ordinal()] = red;
        backgroundItems[BackgroundItemType.GREEN.ordinal()] = green;
        backgroundItems[BackgroundItemType.BLUE.ordinal()] = blue;
        backgroundItems[BackgroundItemType.ALPHA.ordinal()] = alpha;
    }

    @Override
    public float getBackground(BackgroundItemType backgroundItemType)
    {
        return backgroundItems[backgroundItemType.ordinal()];
    }

    @Override
    public void setRainTimeInterval(long time) {
        gameTimeInterval = time;
    }

    @Override
    public long getRainTimeInterval() {
        return gameTimeInterval;
    }
}
