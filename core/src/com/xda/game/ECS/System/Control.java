package com.xda.game.ECS.System;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.xda.game.ECS.Component.Controlable;
import com.xda.game.ECS.Component.Position;
/**
 * Created by alex4o on 4/19/16.
 */
public class Control extends IteratingSystem {
    private ComponentMapper<Position> pm = ComponentMapper.getFor(Position.class);
    private ComponentMapper<Controlable> cm = ComponentMapper.getFor(Controlable.class);

    private int maxVel = 12; // Meters Per Second average for regular person

    public Control(/* World world */) {
        super(Family.all(/* Physics.class, */ Position.class, Controlable.class).get());
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
//        Physics physics = pm.get(entity);
        Controlable ctrl = cm.get(entity);
        Position pos = pm.get(entity);

//        Vector2 pos = physics.body.getPosition();
//        Vector2 vel = physics.body.getLinearVelocity();
//
//        //	float velChange = GameInput.KeyForce.x* this.maxVel - vel.x;
//        //	float impulse = physics.body.getMass() * velChange; //disregard time factor
//        if (vel.x > -12 && vel.x < 12) {
//            physics.body.applyForce(control.gInput.KeyForce.x * 200, 0, pos.x, pos.y, true);
//        } else {
//            float velChange = GameInput.KeyForce.x * this.maxVel - vel.x;
//            float impulse = velChange; //disregard time factor
//            physics.body.applyLinearImpulse(impulse, 0, pos.x, pos.y, true);
//
//        }
//
//        if (control.gInput.up && vel.y == 0) {
//            physics.body.applyForce(0, 8000, pos.x, pos.y, true);
//
//        }
    pos.setVector(pos.getVector().add(ctrl.im.KeyForce));


    }
}