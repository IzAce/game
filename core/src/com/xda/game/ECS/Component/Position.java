package com.xda.game.ECS.Component;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by alex4o on 4/19/16.
 */
public class Position implements Component {
    public float x;
    public float y;

    public Position(float x, float y){
        this.x = x;
        this.y = y;
    }

    public Vector2 getVector(){
        return new Vector2(x, y);
    }

    public void setVector(Vector2 vector){
        this.x = vector.x;
        this.y = vector.y;

    }
}