package com.eduardocode.demo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;

public class GameControl {
    private final Controllable controllable;

    private final ApplicationSettings applicationSettings;

    private final OrthographicCamera camera;

    // we dont want to create this object everytime render runs
    private Vector3 touchPos;

    public GameControl(Controllable controllable, ApplicationSettings applicationSettings, OrthographicCamera camera)
    {
        this.controllable = controllable;
        this.applicationSettings = applicationSettings;
        this.camera = camera;
    }

    public void control()
    {
        touchControl();
        keyControl();
    }

    public void touchControl()
    {
        if(Gdx.input.isTouched())
        {
            touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), applicationSettings.getOriginHeight(), applicationSettings.getOriginDepth());

            touchPos = camera.unproject(touchPos);

            controllable.moveTo(touchPos.x);
        }
    }

    public void keyControl()
    {
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
            controllable.moveLeft(400 * Gdx.graphics.getDeltaTime());

        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            controllable.moveRight(400 * Gdx.graphics.getDeltaTime());
    }
}
