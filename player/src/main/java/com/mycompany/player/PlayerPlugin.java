/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.player;

import com.mycompany.api.IAssetManager;
import com.mycompany.api.IPlugin;
import com.mycompany.api.IWorld;
import com.mycompany.library.ServiceProvider;

/**
 * @author Emil
 */
public class PlayerPlugin implements IPlugin {

    private static String PLAYER_ASSET = "asteroid";

    private IAssetManager assetManager;
    private IWorld world;

    @Override
    public void start() {
        System.out.println("Start Player Plugin");
        world = ServiceProvider.getService(IWorld.class);
        assetManager = ServiceProvider.getService(IAssetManager.class);

        assetManager.loadAsset("asteroid", "asteroid.png");

        world.addEntity(new Player(PLAYER_ASSET, 100, 100));
    }

    @Override
    public void stop() {
        assetManager.unloadAsset(PLAYER_ASSET);
    }

}
