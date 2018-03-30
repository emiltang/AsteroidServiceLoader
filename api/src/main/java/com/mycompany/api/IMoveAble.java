package com.mycompany.api;

/**
 * @author Emil
 */
public interface IMoveAble extends IEntity {

    boolean getTurnLeft();

    void setTurnLeft(boolean b);

    boolean getTurnRight();

    void setTurnRight(boolean b);

    boolean getMoveForward();

    void setMoveForward(boolean b);

    float getAcceleration();

    float getDX();

    void setDX(float dx);

    float getDY();

    void setDY(float dy);

    float getDeceleration();

    float getMaxSpeed();

    float getRotationSpeed();
}
