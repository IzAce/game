package com.xda.game.ECS.System;

import com.badlogic.ashley.core.*;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.xda.game.ECS.Component.Position;
import com.xda.game.ECS.Component.Drawable;

/**
 * Created by alex4o on 4/19/16.
 */
public class Drawing extends EntitySystem {
    private ImmutableArray<Entity> staticEntities;
    private ImmutableArray<Entity> physicsEntities;
    private ImmutableArray<Entity> positionEntities;

    private ImmutableArray<Entity> animatedEntities;

    SpriteBatch batch;
    ShapeRenderer shapeRenderer;
    BitmapFont font = new BitmapFont();


    private ComponentMapper<Drawable> rm = ComponentMapper.getFor(Drawable.class);
   /* private ComponentMapper<Physics> phym = ComponentMapper.getFor(Physics.class);*/
    private ComponentMapper<Position> posm = ComponentMapper.getFor(Position.class);


    public Drawing(SpriteBatch batch) {
        //	shapeRenderer = new ShapeRenderer();
        font.setColor(Color.RED);

        this.batch = batch;
    }

    public void addedToEngine(Engine engine) {
        //physicsEntities = engine.getEntitiesFor(Family.all(Drawable.class, Physics.class).get());
        positionEntities = engine.getEntitiesFor(Family.all(Drawable.class, Position.class).get());
        //staticEntities = engine.getEntitiesFor(Family.all(Drawable.class, Center.class).get());

    }

    public void update(float deltaTime) {
        Gdx.gl.glClearColor(0.6f, 0.6f, 0.6f, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);

        batch.begin();

        int fps = Math.round(1/deltaTime);
        font.draw(batch, String.format("FPS: %d",fps), 1, Gdx.graphics.getHeight());
        Drawable drawable;
        Vector2 position;

        /*for (Entity entity : physicsEntities) {
            drawable = dm.get(entity);
            Physics physics = phym.get(entity);

            position = physics.body.getPosition();
            //batch.draw(drawable.drawable, (position.x * Constants.METER_TO_PIXEL) - drawable.centerH, (position.y * Constants.METER_TO_PIXEL) - drawable.centerW);
            drawable.drawable.setPosition((position.x * Constants.METER_TO_PIXEL) - drawable.centerH, (position.y * Constants.METER_TO_PIXEL) - drawable.centerW);
            drawable.drawable.draw(batch);

        }*/

        for (Entity entity : positionEntities) {
            drawable = rm.get(entity);
            position = posm.get(entity).getVector();
            batch.draw(drawable.sprite, (position.x) - drawable.centerH, (position.y) - drawable.centerW);
        }
/*
		for (Entity entity : staticEntities) {
			drawable = dm.get(entity);
			position = new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
			batch.draw(drawable.drawable, (position.x) - drawable.centerH, (position.y) - drawable.centerW);

		}*/

        batch.end();
    }
}
