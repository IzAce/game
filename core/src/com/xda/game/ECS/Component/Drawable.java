package com.xda.game.ECS.Component;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by alex4o on 4/19/16.
 */
public class Drawable implements Component {
    public Sprite sprite;
    public float centerH;
    public float centerW;

    public Drawable(Texture texture){
        sprite = new Sprite(texture);
        centerH = sprite.getHeight()/2;
        centerW = sprite.getWidth()/2;
    }

    public Drawable(Sprite sprite){
        this.sprite = sprite;
        centerH = sprite.getHeight()/2;
        centerW = sprite.getWidth()/2;
    }
}
