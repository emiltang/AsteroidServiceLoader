/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */
package com.mycompany.asteroid;

import com.mycompany.api.ICollideAble;
import com.mycompany.api.ICollisionAbility;
import com.mycompany.api.IMoveAbility;
import com.mycompany.api.IMoveAble;

/**
 * @author emil
 */
public class Asteroid implements IMoveAble, ICollideAble {

    private final String asset;
    private final ICollisionAbility collisionAbility;
    private final IMoveAbility moveAbility;
    private float x;
    private float y;
    private float rotation;


    Asteroid(final String asset,
             IMoveAbility moveAbility,
             ICollisionAbility collisionAbility) {
        this.asset = asset;
        this.collisionAbility = collisionAbility;
        this.moveAbility = moveAbility;
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

    @Override
    public ICollisionAbility getCollisionAbility() {
        return collisionAbility;
    }

    @Override
    public IMoveAbility getMoveAbility() {
        return moveAbility;
    }
}
