package com.eduardocode.demo;

public interface GameSettings
{
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
        ITEMS_COLLECTED;
    }

    String getAsset(SpriteAsset assetType);
    void setAsset(SpriteAsset assetType, String path);

    String getAsset(SoundAsset assetType);

    void setAsset(SoundAsset assetType, String path);

    String getAsset(TextPlaceholder textPlaceholderType);
    void setAsset(TextPlaceholder textPlaceholderType, String text);
}
