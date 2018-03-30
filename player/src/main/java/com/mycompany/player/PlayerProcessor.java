/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.player;

import com.mycompany.api.IInputService;
import com.mycompany.api.IInputService.Key;
import com.mycompany.api.IProcessor;
import com.mycompany.api.IWorld;
import com.mycompany.library.ServiceLocator;

/**
 * @author Emil
 */
public class PlayerProcessor implements IProcessor {

    private final IWorld world;
    private final IInputService inputService;

    public PlayerProcessor() {
        world = ServiceLocator.getService(IWorld.class);
        inputService = ServiceLocator.getService(IInputService.class);
    }

    @Override
    public void process(float dt) {
        for (var player : world.getEntities(Player.class)) {
            player.setMoveForward(inputService.keyDown(Key.UP));
            player.setTurnLeft(inputService.keyDown(Key.LEFT));
            player.setTurnRight(inputService.keyDown(Key.RIGHT));
        }
    }
}
