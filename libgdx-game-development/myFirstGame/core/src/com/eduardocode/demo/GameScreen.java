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
	private GameSettings gameSettings;
	private final OrthographicCamera camera;

	private final Bucket bucket;
	private final Rain rain;

	private final Music rainMusic;

	// we dont want to create this object everytime render runs
	private Vector3 touchPos;

	private int dropsGathered;

	public GameScreen(final Drop game, GameSettings gameSettings)
	{
		this.game = game;
		this.gameSettings = gameSettings;

		bucket = new Bucket(gameSettings);
		// 1 000 000 000
		rain = new Rain(gameSettings, 1000000000);

		rainMusic = Gdx.audio.newMusic(Gdx.files.internal("sound/rain.mp3"));

		rainMusic.setLooping(true);

		camera = new OrthographicCamera();
		camera.setToOrtho(false, gameSettings.getWidth(), gameSettings.getHeight());
	}

	@Override
	public void render(float delta)
	{
		ScreenUtils.clear(0, 0, 0.2f, 1);
		camera.update();

		game.setBatchProjectionMatrix(camera);

		game.drawInBatch(() ->
		{
			game.font.draw(game.batch,
					"Drops Collected: " + dropsGathered, gameSettings.getOriginWidth(), gameSettings.getHeight());
			bucket.draw(game.batch);
			rain.draw(game.batch);
		});

		if(Gdx.input.isTouched())
		{
			touchPos = new Vector3();
			touchPos.set(Gdx.input.getX(), gameSettings.getOriginHeight(), gameSettings.getOriginDepth());

			touchPos = camera.unproject(touchPos);

			bucket.moveTo(touchPos.x);
		}

		if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
			bucket.moveLeft(400 * Gdx.graphics.getDeltaTime());

		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
			bucket.moveRight(400 * Gdx.graphics.getDeltaTime());


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
