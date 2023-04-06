package com.eduardocode.demo;

public interface GameSettings
{
    void setRainTimeInterval(long time);
    long getRainTimeInterval();

    enum SpriteAsset
    {
        BUCKET, DROP
    }

    enum SoundAsset
    {
        DROP,
        RAIN_MUSIC;
    }

    enum TextPlaceholder
    {
        DROPS_COLLECTED, WELCOME_TO_DROP, TAP_ANYWHERE_TO_BEGIN;
    }

    enum BackgroundItem
    {
        RED, GREEN, BLUE, ALPHA;
    }

    String getAsset(SpriteAsset assetType);
    void setAsset(SpriteAsset assetType, String path);

    String getAsset(SoundAsset assetType);

    void setAsset(SoundAsset assetType, String path);

    String getAsset(TextPlaceholder textPlaceholderType);
    void setAsset(TextPlaceholder textPlaceholderType, String text);

    void setBackground(float red, float green, float blue, float alpha);
    float getBackground(BackgroundItem backgroundItemType);
}
