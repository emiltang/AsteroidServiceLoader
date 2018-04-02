/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.mycompany.player;

import com.mycompany.api.IInputService;
import com.mycompany.api.IInputService.Key;
import com.mycompany.api.IProcessor;
import com.mycompany.api.IWorld;
import com.mycompany.api.ServiceLocator;

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
