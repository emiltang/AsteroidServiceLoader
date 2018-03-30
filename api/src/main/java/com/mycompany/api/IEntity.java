/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.api;

/**
 * @author Emil
 */
public interface IEntity {

    String getAsset();

    float getX();

    void setX(float x);

    float getY();

    void setY(float y);

    float getRotation();

    void setRotation(float v);

}
