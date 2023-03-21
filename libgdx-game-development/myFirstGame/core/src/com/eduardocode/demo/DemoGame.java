package com.eduardocode.demo;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

public class DemoGame extends ApplicationAdapter {

	private Texture dropImage;
	private Texture buckedImage;
	private Sound dropSound;
	private Music rainMusic;

	private OrthographicCamera camera;

	private SpriteBatch batch;

	private Rectangle bucket;

	@Override
	public void create() {
		dropImage = new Texture(Gdx.files.internal("sprite/drop.png"));
		buckedImage = new Texture(Gdx.files.internal("sprite/bucket.png"));

		dropSound = Gdx.audio.newSound(Gdx.files.internal("sound/drop.wav"));
		rainMusic = Gdx.audio.newMusic(Gdx.files.internal("sound/rain.mp3"));

		rainMusic.setLooping(true);
		rainMusic.play();

		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);

		batch = new SpriteBatch(2);

		bucket = new Rectangle();
		bucket.x = 800 / 2 - 64 / 2;
		bucket.y = 20;
		bucket.width = 64;
		bucket.height = 64;
	}

	@Override
	public void render() {
		ScreenUtils.clear(0, 0, 0.2f, 1);
		camera.update();

		batch.setProjectionMatrix(camera.combined);

		batch.begin();
		batch.draw(buckedImage, bucket.x, bucket.y);
		batch.end();

		if(Gdx.input.isTouched()) {
			Vector3 touchPos = new Vector3();
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);

			camera.unproject(touchPos);

			bucket.x = touchPos.x - 64 / 2;
		}
	}
}
