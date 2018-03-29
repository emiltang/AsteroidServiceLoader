package com.myconpany.core;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Asteroids implements ApplicationListener {

    private ShapeRenderer shapeRender;

    @Override
    public void create() {
        shapeRender = new ShapeRenderer();
    }

    @Override
    public void resize(int i, int i1) {
        
    }

    @Override
    public void render() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
    }

}
