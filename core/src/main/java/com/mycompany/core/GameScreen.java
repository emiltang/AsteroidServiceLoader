/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */
package com.mycompany.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mycompany.api.IPlugin;
import com.mycompany.api.IProcessor;
import com.mycompany.api.IWorld;
import com.mycompany.api.ServiceLocator;

import static com.badlogic.gdx.math.MathUtils.radDeg;

/**
 * @author Emil
 */
public class GameScreen implements Screen {

    private final AssetManager assetManager;
    private final IWorld world;
    private final SpriteBatch batch;
    private final Viewport viewport;
    private final Texture bg;

    GameScreen(final SpriteBatch batch) {
        this.world = ServiceLocator.getService(IWorld.class);
        this.assetManager = new AssetManager();
        this.viewport = new FitViewport(IWorld.WIDTH, IWorld.HEIGHT);
        this.batch = batch;
        this.bg = new Texture("bg5.jpg");
    }

    @Override
    public void show() {
        // Start plugins
        ServiceLocator.getServices(IPlugin.class).forEach(IPlugin::start);

        viewport.apply(true);
        batch.setProjectionMatrix(viewport.getCamera().combined);
    }

    @Override
    public void resize(final int x, final int y) {
        viewport.update(x, y, true);
    }

    @Override
    public void render(final float dt) {
        // Update processors
        ServiceLocator.getServices(IProcessor.class).forEach(p -> p.process(dt));

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        batch.begin();
        batch.draw(bg, 0, 0, IWorld.WIDTH, IWorld.HEIGHT);
        world.getEntities().forEach(e -> {
            Texture t = assetManager.getAsset(e.getAsset());
            batch.draw(
                    t,
                    e.getX() - t.getWidth() / 2, e.getY() - t.getHeight() / 2,
                    t.getWidth() / 2, t.getHeight() / 2,
                    t.getWidth(), t.getHeight(),
                    1, 1,
                    e.getRotation() * radDeg,
                    0, 0,
                    t.getWidth(), t.getHeight(),
                    false, false
            );
        });
        batch.end();
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
    public void dispose() {
        ServiceLocator.getServices(IPlugin.class).forEach(IPlugin::stop);
        bg.dispose();
        assetManager.dispose();
    }
}
