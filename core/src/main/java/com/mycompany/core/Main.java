/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.core;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import static com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration.getDesktopDisplayMode;

/**
 * @author Emil
 */
public class Main {

    public static void main(String[] args) {
        var cfg = new LwjglApplicationConfiguration();
        cfg.title = "my-gdx-game";
        cfg.setFromDisplayMode(getDesktopDisplayMode());
        new LwjglApplication(new Asteroids(), cfg);
    }
}
