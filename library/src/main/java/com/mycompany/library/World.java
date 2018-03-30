/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.library;

import com.mycompany.api.IEntity;
import com.mycompany.api.IWorld;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Emil
 */
public class World implements IWorld {
    
    private static final List<IEntity> ENTITIES = new ArrayList<>();
    
    @Override
    public List<IEntity> getEntites() {
        return ENTITIES;
    }
    
    @Override
    public void addEntity(IEntity entity) {
        ENTITIES.add(entity);
    }
}
