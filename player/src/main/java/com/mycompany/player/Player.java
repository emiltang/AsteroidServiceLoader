/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.player;

import com.mycompany.api.IEntity;

/**
 *
 * @author Emil
 */
public class Player implements IEntity {

    private final String asset;
    private float x;
    private float y;

    Player(String asset, float x, float y) {
        this.asset = asset;
        this.x = x;
        this.y = y;
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
    public float getY() {
        return y;
    }
}
