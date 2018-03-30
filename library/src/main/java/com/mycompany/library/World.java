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

import static java.util.stream.Collectors.toList;

/**
 * @author Emil
 */
public class World implements IWorld {

    private static final List<IEntity> ENTITIES = new ArrayList<>();

    @Override
    public List<IEntity> getEntities() {
        return ENTITIES;
    }

    @Override
    public <E extends IEntity> List<E> getEntities(Class<E> type) {
        return ENTITIES.stream()
                .filter(type::isInstance)
                .map(type::cast)
                .collect(toList());
    }

    @Override
    public void addEntity(IEntity entity) {
        ENTITIES.add(entity);
    }

    @Override
    public <E extends IEntity> void removeEntities(List<E> entities) {
        ENTITIES.removeAll(entities);
    }
}
