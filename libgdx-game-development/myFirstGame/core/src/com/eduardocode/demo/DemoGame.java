package com.eduardocode.demo;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class DemoGame extends ApplicationAdapter {

	private Texture dropImage;
	private Texture buckedImage;
	private Sound dropSound;
	private Music rainMusic;

	@Override
	public void create() {
		dropImage = new Texture(Gdx.files.internal("sprite/drop.png"));
		buckedImage = new Texture(Gdx.files.internal("sprite/bucket.png"));

		dropSound = Gdx.audio.newSound(Gdx.files.internal("sound/drop.wav"));
		rainMusic = Gdx.audio.newMusic(Gdx.files.internal("sound/rain.mp3"));

		rainMusic.setLooping(true);
		rainMusic.play();
	}
}
