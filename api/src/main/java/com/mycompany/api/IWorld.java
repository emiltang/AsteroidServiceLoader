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
package com.mycompany.api;

import java.util.List;

/**
 * @author Emil
 */
public interface IWorld {

    int HEIGHT = 2048;
    int WIDTH = 2048;

    List<IEntity> getEntities();

    <E extends IEntity> List<E> getEntities(Class<E> type);

    void addEntity(IEntity entity);

    <E extends IEntity> void removeEntities(List<E> entities);
}
