package com.xda.game;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.xda.game.ECS.Component.Position;
import com.xda.game.ECS.Component.Drawable;
import com.xda.game.ECS.Engine.Engine;
import com.xda.game.ECS.System.Drawing;

public class Game extends ApplicationAdapter {
	SpriteBatch batch;
	Engine engine;
	@Override
	public void create () {
		batch = new SpriteBatch();


		engine = new Engine();
		engine.addSystem(new Drawing(batch));


		Entity player = new Entity();
		player.add(new Position(120,120));
		player.add(new Drawable(new Texture("badlogic.jpg")));

		engine.addEntity(player);



	}

	@Override
	public void render () {
		engine.update(Gdx.graphics.getDeltaTime());
	}

	@Override
	public void	resize(int width, int height){	}

	@Override
	public void pause(){

	}

	@Override
	public void resume(){

	}

	@Override
	public void dispose () {
		batch.dispose();
	}
}
