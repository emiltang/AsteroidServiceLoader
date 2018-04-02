/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */
package com.mycompany.api;

/**
 * @author Emil
 */
public interface IMoveAble extends IEntity {

    boolean isTurnLeft();

    void setTurnLeft(boolean b);

    boolean isTurnRight();

    void setTurnRight(boolean b);

    boolean isMoveForward();

    void setMoveForward(boolean b);

    float getAcceleration();

    float getDx();

    void setDx(float dx);

    float getDy();

    void setDy(float dy);

    float getDeceleration();

    float getMaxSpeed();

    float getRotationSpeed();
}
