package com.xda.game.Util.Managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;

public class InputManager implements InputProcessor{

    public Vector2 KeyForce = new Vector2(0,0);

    public boolean up;
    public boolean down;

    private boolean fullscrean = false;
    public boolean enter = false;
    public boolean alt = false;

    private Thread altTab;

    @Override
    public boolean keyDown(int keycode) {


        if(keycode == Input.Keys.ALT_LEFT || keycode == Input.Keys.ALT_RIGHT )
        {
            
        }

        if(keycode == Input.Keys.A){
            KeyForce.x -= 1;
        }
        if(keycode == Input.Keys.D){
            KeyForce.x += 1;
        }
        if(keycode == Input.Keys.W){
            KeyForce.y += 1;
        }
        if(keycode == Input.Keys.S){
            KeyForce.y -= 1;
        }
        if(keycode == Input.Keys.SPACE){
            up = true;
        }
        if(keycode == Input.Keys.SHIFT_LEFT || keycode == Input.Keys.SHIFT_RIGHT){
            down = true;
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Input.Keys.A) {
            KeyForce.x += 1;
        }
        if (keycode == Input.Keys.D) {
            KeyForce.x -= 1;
        }
        if (keycode == Input.Keys.W) {
            KeyForce.y -= 1;
        }
        if (keycode == Input.Keys.S) {
            KeyForce.y += 1;
        }
        if(keycode == Input.Keys.SPACE){
            up = false;
        }
        if(keycode == Input.Keys.SHIFT_LEFT || keycode == Input.Keys.SHIFT_RIGHT){
            down = false;
        }
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

//            Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());

}
