/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */
package com.mycompany.player;

import com.mycompany.api.IAssetManager;
import com.mycompany.api.IPlugin;
import com.mycompany.api.IWorld;
import com.mycompany.api.ServiceLocator;

import java.util.List;

import static java.lang.Math.PI;
import static java.lang.Math.random;

/**
 * @author Emil
 */
public class PlayerPlugin implements IPlugin {

    private static final String ASSET_KEY = "player";
    private static final String ASSET_PATH = "spaceship.png";
    private static final float ACCELERATION = 100;
    private static final float DECELERATION = 5;
    private static final float MAX_SPEED = 200;
    private static final float ROTATION_SPEED = 5;

    private final IAssetManager assetManager;
    private final IWorld world;

    public PlayerPlugin() {
        world = ServiceLocator.getService(IWorld.class);
        assetManager = ServiceLocator.getService(IAssetManager.class);
    }

    @Override
    public void start() {
        assetManager.loadAsset(ASSET_KEY, ASSET_PATH);
        var player = new Player(ASSET_KEY, ACCELERATION, DECELERATION, MAX_SPEED, ROTATION_SPEED);
        player.setX(IWorld.WIDTH / 2);
        player.setY(IWorld.HEIGHT / 2);
        player.setRotation((float) (random() * 2 * PI));
        world.addEntity(player);
    }

    @Override
    public void stop() {
        assetManager.unloadAsset(ASSET_KEY);
        List<Player> entities = world.getEntities(Player.class);
        world.removeEntities(entities);
    }
}
