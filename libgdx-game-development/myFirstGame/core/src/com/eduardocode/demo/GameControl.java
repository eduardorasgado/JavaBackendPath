package com.eduardocode.demo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;

public class GameControl implements Controllable
{

    private final ApplicationSettings applicationSettings;

    private final OrthographicCamera camera;

    // we dont want to create this object everytime render runs
    private Vector3 touchPos;

    public GameControl(ApplicationSettings applicationSettings, OrthographicCamera camera)
    {
        this.applicationSettings = applicationSettings;
        this.camera = camera;
    }

    public void control(Movabable movabable)
    {
        touchControl(movabable);
        keyControl(movabable);
    }

    public void touchControl(Movabable movabable)
    {
        if(Gdx.input.isTouched())
        {
            touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), applicationSettings.getOriginHeight(), applicationSettings.getOriginDepth());

            touchPos = camera.unproject(touchPos);

            movabable.moveTo(touchPos.x);
        }
    }

    public void keyControl(Movabable movabable)
    {
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
            movabable.moveLeft(400 * Gdx.graphics.getDeltaTime());

        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            movabable.moveRight(400 * Gdx.graphics.getDeltaTime());
    }
}
