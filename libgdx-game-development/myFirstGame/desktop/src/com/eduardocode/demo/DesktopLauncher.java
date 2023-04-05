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

		desktopGameAsset.setAsset(GameSettings.SpriteAsset.BUCKET, "sprite/bucket.png");
		desktopGameAsset.setAsset(GameSettings.SpriteAsset.DROP, "sprite/drop.png");

		desktopGameAsset.setAsset(GameSettings.SoundAsset.DROP, "sound/drop.wav");
		desktopGameAsset.setAsset(GameSettings.SoundAsset.RAIN_MUSIC, "sound/rain.mp3");

		desktopGameAsset.setAsset(GameSettings.TextPlaceholder.ITEMS_COLLECTED, "Drops Collected: ");

		return desktopGameAsset;
	}
}
