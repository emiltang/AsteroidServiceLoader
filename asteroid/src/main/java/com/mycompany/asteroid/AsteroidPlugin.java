/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */
package com.mycompany.asteroid;

import com.mycompany.api.IAssetManager;
import com.mycompany.api.IPlugin;
import com.mycompany.api.IWorld;
import com.mycompany.api.ServiceLocator;
import com.mycompany.library.CollisionAbility;
import com.mycompany.library.MoveAbility;

import static java.lang.Math.PI;
import static java.lang.Math.random;

/**
 * @author emil
 */
public class AsteroidPlugin implements IPlugin {

    private static final String ASSET_KEY = "asteroid";
    private static final String ASSET_PATH = "asteroid.png";
    private static final float ACCELERATION = Integer.MAX_VALUE;
    private static final float DECELERATION = 0;
    private static final float MAX_SPEED = 20;
    private static final float ROTATION_SPEED = 0;
    private static final int NUM_ASTEROIDS = 10;
    private static final int DAMAGE = 100;
    private static final int HIT_RADIUS = 64;

    private final IAssetManager assetManager;
    private final IWorld world;

    public AsteroidPlugin() {
        assetManager = ServiceLocator.getService(IAssetManager.class);
        world = ServiceLocator.getService(IWorld.class);
    }

    @Override
    public void start() {
        assetManager.loadAsset(ASSET_KEY, ASSET_PATH);

        for (int i = 0; i < NUM_ASTEROIDS; i++) {
            var asteroid = new Asteroid(
                    ASSET_KEY,
                    new MoveAbility(ACCELERATION, DECELERATION, MAX_SPEED, ROTATION_SPEED),
                    new CollisionAbility(DAMAGE, HIT_RADIUS)
            );
            asteroid.setX((float) (random() * IWorld.WIDTH));
            asteroid.setY((float) (random() * IWorld.HEIGHT));
            asteroid.getMoveAbility().setMoveForward(true);
            asteroid.setRotation((float) (random() * 2 * PI));
            world.addEntity(asteroid);
        }
    }

    @Override
    public void stop() {
        assetManager.unloadAsset(ASSET_KEY);
    }
}
