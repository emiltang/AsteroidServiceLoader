package com.myconpany.core;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mycompany.api.*;
import com.mycompany.library.ServiceProvider;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;

public class Asteroids implements ApplicationListener {

    private IWorld world;
    private SpriteBatch batch;
    private final AssetManager assetManager = new AssetManager();

    @Override
    public void create() {

        ClassLoader cl = ClassLoader.getSystemClassLoader();

        URL[] urls = ((URLClassLoader) cl).getURLs();

        for (URL url : urls) {
            System.out.println(url.getFile());
        }

        System.out.println("Starting game");

        for (IPlugin p : ServiceProvider.getServices(IPlugin.class)) {
            System.out.println(p);
            p.start();
        }
        batch = new SpriteBatch();
        world = ServiceProvider.getService(IWorld.class);

    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void render() {
        // Update
        ServiceProvider.getServices(IProcessor.class).forEach(IProcessor::Process);

        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        batch.begin();
        world.getEntites().forEach(entity -> batch.draw(
                assetManager.getAsset(entity.getAsset()),
                entity.getX(), entity.getY()
        ));
        batch.end();
        if (Gdx.input.isKeyJustPressed(Input.Keys.S)) {
            System.out.println("wtf");
            List<IPlugin> plugins = ServiceProvider.getServices(IPlugin.class);
            for (IPlugin p : plugins) {
                System.out.println(p);
                p.start();
            }
        }
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
