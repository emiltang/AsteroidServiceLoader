/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */
package com.mycompany.player;

import com.mycompany.api.*;

/**
 * @author Emil
 */
public class Player implements IMoveAble, IEntity, ICollideAble {

    private final String asset;
    private final IMoveAbility moveAbility;
    private final ICollisionAbility collisionAbility;

    private float x;
    private float y;
    private float rotation;
    private int healthPoints;

    Player(final String asset,
           final int healthPoints,
           IMoveAbility moveAbility,
           ICollisionAbility collisionAbility) {
        this.asset = asset;
        this.healthPoints = healthPoints;
        this.moveAbility = moveAbility;
        this.collisionAbility = collisionAbility;
    }

    @Override
    public String getAsset() {
        return asset;
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public void setX(float x) {
        this.x = x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public void setY(float y) {
        this.y = y;
    }

    @Override
    public float getRotation() {
        return rotation;
    }

    @Override
    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    int getHealthPoints() {
        return healthPoints;
    }

    void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    @Override
    public IMoveAbility getMoveAbility() {
        return moveAbility;
    }

    @Override
    public ICollisionAbility getCollisionAbility() {
        return collisionAbility;
    }
}
