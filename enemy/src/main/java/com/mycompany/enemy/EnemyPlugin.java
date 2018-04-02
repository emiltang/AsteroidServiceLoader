/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.mycompany.enemy;

import com.mycompany.api.IAssetManager;
import com.mycompany.api.IPlugin;
import com.mycompany.api.IWorld;
import com.mycompany.api.ServiceLocator;

import static java.lang.Math.PI;
import static java.lang.Math.random;

public class EnemyPlugin implements IPlugin {

    private static final String ASSET_KEY = "enemy";
    private static final String ASSET_PATH = "spaceship1.png";
    private static final float ACCELERATION = 100;
    private static final float DECELERATION = 5;
    private static final float MAX_SPEED = 200;
    private static final float ROTATION_SPEED = 5;

    private final IAssetManager assetManager;
    private final IWorld world;

    public EnemyPlugin() {
        assetManager = ServiceLocator.getService(IAssetManager.class);
        world = ServiceLocator.getService(IWorld.class);
    }

    @Override
    public void start() {
        assetManager.loadAsset(ASSET_KEY, ASSET_PATH);
        var enemy = new Enemy(
                ASSET_KEY,
                ACCELERATION,
                DECELERATION,
                MAX_SPEED,
                ROTATION_SPEED
        );
        enemy.setX((float) (random() * IWorld.WIDTH));
        enemy.setY((float) (random() * IWorld.HEIGHT));
        enemy.setMoveForward(true);
        enemy.setRotation((float) (random() * 2 * PI));
        world.addEntity(enemy);
    }

    @Override
    public void stop() {
        assetManager.unloadAsset(ASSET_KEY);
    }
}
