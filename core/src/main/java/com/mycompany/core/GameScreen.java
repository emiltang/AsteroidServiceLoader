package com.mycompany.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mycompany.api.IEntity;
import com.mycompany.api.IPlugin;
import com.mycompany.api.IProcessor;
import com.mycompany.api.IWorld;
import com.mycompany.library.ServiceLocator;

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
    public void resize(int x, int y) {
        viewport.update(x, y, true);
    }


    private void drawEntity(IEntity e) {
        Texture texture = assetManager.getAsset(e.getAsset());
        batch.draw(
                texture, //The texture to use
                e.getX() - texture.getWidth() / 2, //Position x to draw
                e.getY() - texture.getHeight() / 2, //Position y to draw
                texture.getWidth() / 2,
                texture.getHeight() / 2,
                texture.getWidth(),
                texture.getHeight(),
                1,
                1,
                e.getRotation() * radDeg,
                0, 0,
                texture.getWidth(),
                texture.getHeight(),
                false,
                false
        );
    }

    @Override
    public void render(float dt) {
        // Update processors
        ServiceLocator.getServices(IProcessor.class).forEach(p -> p.process(dt));

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        batch.begin();
        batch.draw(bg, 0, 0, IWorld.WIDTH, IWorld.HEIGHT);
        world.getEntities().forEach(this::drawEntity);
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
        bg.dispose();
        assetManager.dispose();
    }
}
