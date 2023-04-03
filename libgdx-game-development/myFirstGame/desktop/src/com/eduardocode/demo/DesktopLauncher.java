package com.eduardocode.demo;


import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

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
		DesktopSettings settings = new DesktopSettings("Drops", 800, 480, 60, true);
		new Lwjgl3Application(new Drop(settings), getConfiguration(settings));
	}


	private Lwjgl3ApplicationConfiguration getConfiguration(DesktopSettings gameSettings)
	{
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		gameSettings.configure(config);

		return config;
	}
}
