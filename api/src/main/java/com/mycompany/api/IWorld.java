/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.api;

import java.util.List;

/**
 * @author Emil
 */
public interface IWorld {

    float HEIGHT = 800;
    float WIDTH = 800;

    List<IEntity> getEntities();

    <E extends IEntity> List<E> getEntities(Class<E> type);

    void addEntity(IEntity entity);

    <E extends IEntity> void removeEntities(List<E> entities);
}
