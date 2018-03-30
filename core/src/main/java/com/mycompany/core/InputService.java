package com.mycompany.core;

import com.mycompany.api.IInputService;

import static com.badlogic.gdx.Gdx.input;
import static com.badlogic.gdx.Input.Keys;

public class InputService implements IInputService {

    @Override
    public boolean keyDown(Key k) {
        switch (k) {
            case RIGHT:
                return input.isKeyPressed(Keys.RIGHT);
            case LEFT:
                return input.isKeyPressed(Keys.LEFT);
            case UP:
                return input.isKeyPressed(Keys.UP);
            default:
                return false;
        }
    }
}
