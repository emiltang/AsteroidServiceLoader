/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.api;

/**
 *
 * @author Emil
 */
public interface IAssetManager {
    
    void loadAsset(String key, String path);

    void unloadAsset(String key);
}
