package com.eduardocode.demo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameScreen implements Screen
{
	private final Drop game;

	private final GameSettings gameSettings;

	private final OrthographicCamera camera;

	private final Bucket bucket;

	private final Rain rain;

	private final Music rainMusic;

	private final GameControl gameControl;

	private final GameScore score;


	public GameScreen(final Drop game, ApplicationSettings applicationSettings, GameSettings gameSettings)
	{
		this.game = game;
		this.gameSettings = gameSettings;

		bucket = new Bucket(applicationSettings, gameSettings);
		rain = new Rain(applicationSettings, gameSettings.getRainTimeInterval(), gameSettings);

		rainMusic = Gdx.audio.newMusic(Gdx.files.internal(gameSettings.getAsset(GameSettings.SoundAsset.RAIN_MUSIC)));
		rainMusic.setLooping(true);

		camera = new OrthographicCamera();
		camera.setToOrtho(false, applicationSettings.getWidth(), applicationSettings.getHeight());

		gameControl = new GameControl(bucket.getControls(), applicationSettings, camera);

		score = new GameScore(game, applicationSettings, gameSettings, new RainGatheredChecker(gameSettings));
	}

	@Override
	public void render(float delta)
	{
		ScreenUtils.clear(
				gameSettings.getBackground(GameSettings.BackgroundItem.RED),
				gameSettings.getBackground(GameSettings.BackgroundItem.GREEN),
				gameSettings.getBackground(GameSettings.BackgroundItem.BLUE),
				gameSettings.getBackground(GameSettings.BackgroundItem.ALPHA));

		camera.update();

		game.setBatchProjectionMatrix(camera);

		game.drawInBatch(score, bucket, rain);

		gameControl.control();

		if (rain.canSpawnRaindrop())
			rain.spawnRaindrop();

		rain.moveDown(200 * Gdx.graphics.getDeltaTime());
		score.updateNewScore(rain, bucket);
	}

	@Override
	public void show()
	{
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
		score.dispose();
	}
}
