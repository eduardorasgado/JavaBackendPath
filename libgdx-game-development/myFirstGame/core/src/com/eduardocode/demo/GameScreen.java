package com.eduardocode.demo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameScreen implements Screen
{
	private Drop game;
	private final OrthographicCamera camera;

	private final Bucket bucket;

	private final Rain rain;

	private final Music rainMusic;

	private final GameControl gameControl;

	private int dropsGathered;

	private final ScreenText scoreText;

	public GameScreen(final Drop game, GameSettings gameSettings)
	{
		this.game = game;

		bucket = new Bucket(gameSettings);
		// 1 000 000 000
		rain = new Rain(gameSettings, 1000000000);

		rainMusic = Gdx.audio.newMusic(Gdx.files.internal("sound/rain.mp3"));

		rainMusic.setLooping(true);

		camera = new OrthographicCamera();
		camera.setToOrtho(false, gameSettings.getWidth(), gameSettings.getHeight());

		scoreText = new ScreenText();
		scoreText.setxPosition(gameSettings.getOriginWidth());
		scoreText.setyPosition(gameSettings.getHeight());

		game.assignFont(scoreText);

		gameControl = new GameControl(bucket, gameSettings, camera);
	}

	@Override
	public void render(float delta)
	{
		ScreenUtils.clear(0, 0, 0.2f, 1);
		camera.update();

		game.setBatchProjectionMatrix(camera);

		scoreText.setText("Drops Collected: " + dropsGathered);
		game.drawInBatch(scoreText, bucket, rain);

		gameControl.control();

		if (rain.canSpawnRaindrop())
			rain.spawnRaindrop();

		rain.moveDown(200 * Gdx.graphics.getDeltaTime());
		dropsGathered += rain.gatherRaindrops(bucket);
	}

	@Override
	public void show() {
		rainMusic.play();
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void hide() {

	}

	@Override
	public void dispose()
	{
		bucket.dispose();
		rain.dispose();
		rainMusic.dispose();
	}
}
