/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.api;

import java.util.List;

/**
 *
 * @author Emil
 */
public interface IWorld {

    List<IEntity> getEntites();

    void addEntity(IEntity entity);

}
