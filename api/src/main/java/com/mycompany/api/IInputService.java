package com.mycompany.api;

public interface IInputService {

    boolean keyDown(Key k);


    enum Key {
        LEFT,
        RIGHT,
        UP
    }

}
