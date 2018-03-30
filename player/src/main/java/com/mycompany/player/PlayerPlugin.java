/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.player;

import com.mycompany.api.IAssetManager;
import com.mycompany.api.IPlugin;
import com.mycompany.api.IWorld;
import com.mycompany.api.ServiceLocator;

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
        var p = new Player(ASSET_KEY, ACCELERATION, DECELERATION, MAX_SPEED, ROTATION_SPEED);
        p.setX(IWorld.WIDTH / 2);
        p.setY(IWorld.HEIGHT / 2);
        world.addEntity(p);
    }

    @Override
    public void stop() {
        assetManager.unloadAsset(ASSET_KEY);
        var entities = world.getEntities(Player.class);
        world.removeEntities(entities);
    }
}
