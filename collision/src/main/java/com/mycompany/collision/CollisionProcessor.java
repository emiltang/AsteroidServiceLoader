/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */
package com.mycompany.collision;

import com.mycompany.api.ICollideAble;
import com.mycompany.api.IProcessor;
import com.mycompany.api.IWorld;
import com.mycompany.api.ServiceLocator;

import java.util.List;

import static java.lang.Math.pow;

/**
 * @author emil
 */
public class CollisionProcessor implements IProcessor {

    private final IWorld world;

    public CollisionProcessor() {
        world = ServiceLocator.getService(IWorld.class);
    }

    @Override
    public void process(float deltaTime) {
        List<ICollideAble> entities = world.getEntities(ICollideAble.class);
        for (var c0 : entities) {
            c0.getCollisionAbility().clearCollisions();
            for (var c1 : entities)
                if (c0 != c1 && pow(c0.getCollisionAbility().getHitRadius() + c1.getCollisionAbility().getHitRadius(), 2)
                        > pow(c0.getX() - c1.getX(), 2) + pow(c0.getY() - c1.getY(), 2))
                    c0.getCollisionAbility().addCollision(c1);

        }
    }
}
