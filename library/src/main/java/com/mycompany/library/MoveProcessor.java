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

            if (m.getTurnLeft()) m.setRotation(m.getRotation() + m.getRotationSpeed() * dt);
            if (m.getTurnRight()) m.setRotation(m.getRotation() - m.getRotationSpeed() * dt);

            if (m.getMoveForward()) {
                m.setDX((float) (m.getDX() + cos(m.getRotation()) * m.getAcceleration() * dt));
                m.setDY((float) (m.getDY() + sin(m.getRotation()) * m.getAcceleration() * dt));
            }
            float vec = (float) sqrt(m.getDX() * m.getDX() + m.getDY() * m.getDY());
            if (vec > 0) {
                m.setDX(m.getDX() - (m.getDX() / vec) * m.getDeceleration() * dt);
                m.setDY(m.getDY() - (m.getDY() / vec) * m.getDeceleration() * dt);
            }
            if (vec > m.getMaxSpeed()) {
                m.setDX((m.getDX() / vec) * m.getMaxSpeed());
                m.setDY((m.getDY() / vec) * m.getMaxSpeed());
            }

            m.setX(m.getX() + m.getDX() * dt);
            if (m.getX() > IWorld.WIDTH) m.setX(0);
            else if (m.getX() < 0) m.setX(IWorld.WIDTH);

            m.setY(m.getY() + m.getDY() * dt);
            if (m.getY() > IWorld.HEIGHT) m.setY(0);
            else if (m.getY() < 0) m.setY(IWorld.HEIGHT);
        }
    }
}
