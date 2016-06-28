package com.wp.androidgameengine.engine.objects.enemy;

import com.wp.androidgameengine.engine.objects.Entity;
import com.wp.androidgameengine.engine.objects.Texture;
import com.wp.androidgameengine.engine.objects.Vec2;
import com.wp.androidgameengine.engine.objects.components.animation.IAnimable;
import com.wp.androidgameengine.engine.threads.ThreadCommunicator;

public class Enemy extends Entity implements IAnimable {

    private final float orderProbability;
    private final float spawnProbability;

    public Enemy(Vec2 position, Vec2 dimensions, float orderProbability, float spawnProbability){
        super(position, dimensions);

        this.orderProbability = orderProbability;
        this.spawnProbability = spawnProbability;
    }

    @Override
    protected void customUpdate(long timeDelta, ThreadCommunicator tc) {

    }

    @Override
    public void setCurrentAnimationFrame(Texture texture) {
        currentTexture = texture;
    }

    float getOrderProbability() {
        return orderProbability;
    }

    float getSpawnProbability() {
        return spawnProbability;
    }

    Enemy clone(Vec2 atPosition){
        Enemy newEnemy = new Enemy(atPosition, getDimensions(), getOrderProbability(), getSpawnProbability());

        newEnemy.copyProtected(this);

        return newEnemy;
    }
}
