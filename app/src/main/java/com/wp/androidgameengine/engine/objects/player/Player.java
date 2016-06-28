package com.wp.androidgameengine.engine.objects.player;

import com.wp.androidgameengine.engine.objects.Entity;
import com.wp.androidgameengine.engine.objects.Texture;
import com.wp.androidgameengine.engine.objects.Vec2;
import com.wp.androidgameengine.engine.objects.components.animation.IAnimable;
import com.wp.androidgameengine.engine.threads.ThreadCommunicator;

public class Player extends Entity implements IAnimable{

    public Player(Vec2 position, Vec2 dimensions){
        super(position, dimensions);
    }

    @Override
    protected void customUpdate(long timeDelta, ThreadCommunicator tc) {

    }

    @Override
    public void setCurrentAnimationFrame(Texture texture) {
        currentTexture = texture;
    }
}
