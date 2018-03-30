/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.core;

import com.badlogic.gdx.graphics.Texture;
import com.mycompany.api.IAssetManager;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Emil
 */
public class AssetManager implements IAssetManager {

    private static final Map<String, Texture> ASSETS = new HashMap<>();

    Texture getAsset(String key) {
        return ASSETS.get(key);
    }

    @Override
    public void loadAsset(String key, String path) {
        ASSETS.put(key, new Texture(path));
    }

    @Override
    public void unloadAsset(String key) {
        ASSETS.remove(key);
    }

}
