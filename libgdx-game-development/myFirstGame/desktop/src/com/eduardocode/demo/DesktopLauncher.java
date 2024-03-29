package com.eduardocode.demo;


import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

import java.util.HashMap;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher
{

	public static void main (String[] arg)
	{
		DesktopLauncher desktopLauncher = new DesktopLauncher();
		desktopLauncher.start();
	}

	private void start()
	{
		DesktopSettings settings = new DesktopSettings("Drops", 480, 800, 60, true);
		DesktopGameSettings gameAsset = buildGameSettings();
		new Lwjgl3Application(new Drop(settings, gameAsset), getConfiguration(settings));
	}


	private Lwjgl3ApplicationConfiguration getConfiguration(DesktopSettings gameSettings)
	{
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		gameSettings.configure(config);

		return config;
	}

	private DesktopGameSettings buildGameSettings()
	{

		DesktopGameSettings desktopGameAsset = new DesktopGameSettings(new HashMap<>(), new HashMap<>(), new HashMap<>());

		desktopGameAsset.setAsset(GameSettings.SpriteAssetType.BUCKET, new SpriteAsset("sprite/bucket.png", 64, 64));
		desktopGameAsset.setAsset(GameSettings.SpriteAssetType.DROP, new SpriteAsset("sprite/drop.png", 64, 64));

		desktopGameAsset.setAsset(GameSettings.SoundAssetType.DROP, "sound/drop.wav");
		desktopGameAsset.setAsset(GameSettings.SoundAssetType.RAIN_MUSIC, "sound/rain.mp3");

		desktopGameAsset.setAsset(GameSettings.TextPlaceholderType.DROPS_COLLECTED, "Drops Collected: ");
		desktopGameAsset.setAsset(GameSettings.TextPlaceholderType.WELCOME_TO_DROP, "Welcome to Drop!!! ");
		desktopGameAsset.setAsset(GameSettings.TextPlaceholderType.TAP_ANYWHERE_TO_BEGIN, "Tap anywhere to begin!");

		desktopGameAsset.setBackground(0, 0, 0.2f, 1);
		desktopGameAsset.setRainTimeInterval(1000000000);

		return desktopGameAsset;
	}
}
