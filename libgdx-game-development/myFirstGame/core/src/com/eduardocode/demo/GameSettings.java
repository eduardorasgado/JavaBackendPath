package com.eduardocode.demo;

public interface GameSettings
{
    void setRainTimeInterval(long time);
    long getRainTimeInterval();

    enum SpriteAssetType
    {
        BUCKET, DROP
    }

    enum SoundAssetType
    {
        DROP,
        RAIN_MUSIC;
    }

    enum TextPlaceholderType
    {
        DROPS_COLLECTED, WELCOME_TO_DROP, TAP_ANYWHERE_TO_BEGIN;
    }

    enum BackgroundItemType
    {
        RED, GREEN, BLUE, ALPHA;
    }

    SpriteAsset getAsset(SpriteAssetType assetType);
    void setAsset(SpriteAssetType assetType, SpriteAsset asset);

    String getAsset(SoundAssetType assetType);

    void setAsset(SoundAssetType assetType, String path);

    String getAsset(TextPlaceholderType textPlaceholderType);
    void setAsset(TextPlaceholderType textPlaceholderType, String text);

    void setBackground(float red, float green, float blue, float alpha);
    float getBackground(BackgroundItemType backgroundItemType);
}
