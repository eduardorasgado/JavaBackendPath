package com.eduardocode.demo;

import java.util.Map;
import java.util.NoSuchElementException;


public class DesktopGameSettings extends CommonGameSettings
{
    private final Asset<SpriteAssetType, SpriteAsset> spriteAsset;

    private final Asset<SoundAssetType, String> soundAsset;

    private final Asset<TextPlaceholderType, String> textPlacehoder;

    public DesktopGameSettings(Map<SpriteAssetType, SpriteAsset> spriteAssets,
                               Map<SoundAssetType, String> soundAssets,
                               Map<TextPlaceholderType, String> textPlaceholderStringMap) {
        spriteAsset = new Asset<>(spriteAssets);
        soundAsset = new Asset<>(soundAssets);
        textPlacehoder = new Asset<>(textPlaceholderStringMap);
    }

    @Override
    public SpriteAsset getAsset(SpriteAssetType assetType) {
        assert(assetType != null);

        return spriteAsset.getAsset(assetType);
    }

    @Override
    public void setAsset(SpriteAssetType assetType, SpriteAsset asset) {
        assert(assetType != null && asset != null);

        spriteAsset.setAsset(assetType, asset);
    }

    @Override
    public String getAsset(SoundAssetType assetType) {
        assert(assetType != null);

        return soundAsset.getAsset(assetType);
    }

    @Override
    public void setAsset(SoundAssetType assetType, String path) {
        assert(assetType != null && path != null);

        soundAsset.setAsset(assetType, path);
    }

    @Override
    public void setAsset(TextPlaceholderType textPlaceholderType, String text) {
        assert(textPlaceholderType != null && text != null);

        textPlacehoder.setAsset(textPlaceholderType, text);
    }

    @Override
    public String getAsset(TextPlaceholderType textPlaceholderType) {
        assert(textPlaceholderType != null);

        return textPlacehoder.getAsset(textPlaceholderType);
    }

    private record Asset<K, V>(Map<K, V> assets)
    {

        public void setAsset(K assetType, V asset) {
            assert (assetType != null && asset != null);

            if (assets.containsKey(assetType)) {
                assets.replace(assetType, asset);
            } else {
                assets.put(assetType, asset);
            }
        }

        public V getAsset(K assetType) {
            assert (assetType != null);

            if (!assets.containsKey(assetType)) {
                throw new NoSuchElementException();
            }

            return assets.get(assetType);
        }
    }
}
