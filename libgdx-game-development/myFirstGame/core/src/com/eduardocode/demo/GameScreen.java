package com.eduardocode.demo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.Iterator;

public class GameScreen implements Screen
{

	private Drop game;

	private Texture dropImage;
	private Texture bucketImage;
	private Sound dropSound;
	private Music rainMusic;

	private OrthographicCamera camera;

	private Rectangle bucket;

	private Array<Rectangle> raindrops;

	private Vector3 touchPos;

	private int dropsGathered;

	private long lastDropTime;

	public GameScreen(final Drop game)
	{
		this.game = game;

		dropImage = new Texture(Gdx.files.internal("sprite/drop.png"));
		bucketImage = new Texture(Gdx.files.internal("sprite/bucket.png"));

		dropSound = Gdx.audio.newSound(Gdx.files.internal("sound/drop.wav"));
		rainMusic = Gdx.audio.newMusic(Gdx.files.internal("sound/rain.mp3"));

		rainMusic.setLooping(true);

		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);

		game.batch = new SpriteBatch(2);

		bucket = new Rectangle();
		bucket.x = 800 / 2 - 64 / 2;
		bucket.y = 20;
		bucket.width = 64;
		bucket.height = 64;

		raindrops = new Array<>();
		spawnRaindrop();
	}

	@Override
	public void render(float delta)
	{
		ScreenUtils.clear(0, 0, 0.2f, 1);
		camera.update();

		game.batch.setProjectionMatrix(camera.combined);

		game.batch.begin();
		game.font.draw(game.batch, "Drops Collected: " + dropsGathered, 0, 480);
		game.batch.draw(bucketImage, bucket.x, bucket.y, bucket.width, bucket.height);

		for (Rectangle raindrop : raindrops) game.batch.draw(dropImage, raindrop.x, raindrop.y);
		game.batch.end();

		if(Gdx.input.isTouched())
		{
			touchPos = new Vector3();
			touchPos.set(Gdx.input.getX(), 0, 0);

			touchPos = camera.unproject(touchPos);

			bucket.x = touchPos.x - 64 / 2;
		}

		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) bucket.x -= 400 * Gdx.graphics.getDeltaTime();

		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) bucket.x += 400 * Gdx.graphics.getDeltaTime();

		if(bucket.x < 0) bucket.x = 0;
		if(bucket.x + 64 > 800) bucket.x = 800 - 64;

		// 1 000 000 000
		if(TimeUtils.nanoTime() - lastDropTime > 1000000000) spawnRaindrop();
		
		for (Iterator<Rectangle> iterator = raindrops.iterator(); iterator.hasNext(); )
		{
			Rectangle raindrop = iterator.next();
			raindrop.y -= 200 * Gdx.graphics.getDeltaTime();

			if (raindrop.y + 64 < 0) iterator.remove();

			if(raindrop.overlaps(bucket))
			{
				dropSound.play();
				iterator.remove();
				++dropsGathered;
			}
		}
	}

	private void spawnRaindrop()
	{
		Rectangle raindrop = new Rectangle();
		raindrop.x = MathUtils.random(0, 800 - 64);
		raindrop.y = 480;
		raindrop.width = 64;
		raindrop.height = 64;
		raindrops.add(raindrop);
		lastDropTime = TimeUtils.nanoTime();
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
		dropImage.dispose();
		bucketImage.dispose();
		dropSound.dispose();
		rainMusic.dispose();
	}
}
