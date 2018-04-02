/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.mycompany.library;

import com.mycompany.api.IMoveAble;
import com.mycompany.api.IProcessor;
import com.mycompany.api.IWorld;
import com.mycompany.api.ServiceLocator;

import static java.lang.Math.*;

/**
 * @author Emil
 */
public class MoveProcessor implements IProcessor {

    private final IWorld world;

    public MoveProcessor() {
        world = ServiceLocator.getService(IWorld.class);
    }

    @Override
    public void process(float dt) {
        for (var m : world.getEntities(IMoveAble.class)) {

            // TL;DR: stuff moves

            if (m.isTurnLeft()) m.setRotation(m.getRotation() + m.getRotationSpeed() * dt);
            if (m.isTurnRight()) m.setRotation(m.getRotation() - m.getRotationSpeed() * dt);

            if (m.isMoveForward()) {
                m.setDx((float) (m.getDx() + cos(m.getRotation()) * m.getAcceleration() * dt));
                m.setDy((float) (m.getDy() + sin(m.getRotation()) * m.getAcceleration() * dt));
            }
            float vec = (float) sqrt(m.getDx() * m.getDx() + m.getDy() * m.getDy());
            if (vec > 0) {
                m.setDx(m.getDx() - (m.getDx() / vec) * m.getDeceleration() * dt);
                m.setDy(m.getDy() - (m.getDy() / vec) * m.getDeceleration() * dt);
            }
            if (vec > m.getMaxSpeed()) {
                m.setDx((m.getDx() / vec) * m.getMaxSpeed());
                m.setDy((m.getDy() / vec) * m.getMaxSpeed());
            }

            m.setX(m.getX() + m.getDx() * dt);
            if (m.getX() > IWorld.WIDTH) m.setX(0);
            else if (m.getX() < 0) m.setX(IWorld.WIDTH);

            m.setY(m.getY() + m.getDy() * dt);
            if (m.getY() > IWorld.HEIGHT) m.setY(0);
            else if (m.getY() < 0) m.setY(IWorld.HEIGHT);
        }
    }
}
