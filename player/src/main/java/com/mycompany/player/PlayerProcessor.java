/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.player;

import com.mycompany.api.IProcessor;

/**
 *
 * @author Emil
 */
public class PlayerProcessor implements IProcessor{

    @Override
    public void Process() {
        System.out.println("processing players");    }
    
}
