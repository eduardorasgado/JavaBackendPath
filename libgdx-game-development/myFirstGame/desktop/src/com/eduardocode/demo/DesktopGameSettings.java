package com.eduardocode.demo;

import java.util.Map;
import java.util.NoSuchElementException;


public class DesktopGameSettings extends CommonGameSettings
{
    private final Asset<SpriteAsset> spriteAsset;

    private final Asset<SoundAsset> soundAsset;

    private final Asset<TextPlaceholder> textPlacehoder;

    public DesktopGameSettings(Map<SpriteAsset, String> spriteAssets,
                               Map<SoundAsset, String> soundAssets,
                               Map<TextPlaceholder, String> textPlaceholderStringMap) {
        spriteAsset = new Asset<>(spriteAssets);
        soundAsset = new Asset<>(soundAssets);
        textPlacehoder = new Asset<>(textPlaceholderStringMap);
    }

    @Override
    public String getAsset(SpriteAsset assetType) {
        assert(assetType != null);

        return spriteAsset.getAsset(assetType);
    }

    @Override
    public void setAsset(SpriteAsset assetType, String path) {
        assert(assetType != null && path != null);

        spriteAsset.setAsset(assetType, path);
    }

    @Override
    public String getAsset(SoundAsset assetType) {
        assert(assetType != null);

        return soundAsset.getAsset(assetType);
    }

    @Override
    public void setAsset(SoundAsset assetType, String path) {
        assert(assetType != null && path != null);

        soundAsset.setAsset(assetType, path);
    }

    @Override
    public void setAsset(TextPlaceholder textPlaceholderType, String text) {
        assert(textPlaceholderType != null && text != null);

        textPlacehoder.setAsset(textPlaceholderType, text);
    }

    @Override
    public String getAsset(TextPlaceholder textPlaceholderType) {
        assert(textPlaceholderType != null);

        return textPlacehoder.getAsset(textPlaceholderType);
    }

    private record Asset<T>(Map<T, String> spriteAssets) {

        public void setAsset(T assetType, String path) {
                assert (assetType != null && path != null);

                if (spriteAssets.containsKey(assetType)) {
                    spriteAssets.replace(assetType, path);
                } else {
                    spriteAssets.put(assetType, path);
                }
            }

            public String getAsset(T assetType) {
                assert (assetType != null);

                if (!spriteAssets.containsKey(assetType)) {
                    throw new NoSuchElementException();
                }

                return spriteAssets.get(assetType);
            }
        }
}
