package com.xda.game.ECS.Component;

import com.badlogic.ashley.core.Component;
import com.xda.game.Util.Managers.InputManager;

/**
 * Created by alex4o on 4/19/16.
 */
public class Controlable implements Component{
    public InputManager im;

    public Controlable(InputManager im) {
        this.im = im;
    }
}
