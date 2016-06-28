package com.wp.androidgameengine.game.components;

import com.wp.androidgameengine.engine.exceptions.NotLoadedException;
import com.wp.androidgameengine.engine.objects.Sound;
import com.wp.androidgameengine.engine.objects.Vec2;
import com.wp.androidgameengine.engine.objects.components.IComponent;
import com.wp.androidgameengine.engine.objects.components.IComposable;
import com.wp.androidgameengine.engine.objects.components.movable.IMovable;
import com.wp.androidgameengine.engine.watchdog.GuardedObject;

public class Physics extends GuardedObject implements IComponent {

    private IMovable movable;
    private float movableHeight;

    private final float gravity = -9.71f;

    private final int groundY;

    public Physics(int groundY){
        super();

        this.groundY = groundY;
    }

    private float acceleration;
    private float velocity = 0;

    private Vec2 currentPosition;

    private boolean isMoveBlocked = false;

    @Override
    public void perform(IComposable composable, long timeDelta) {

        movable = (IMovable)composable;
        movableHeight = movable.getDimensions().getY();

        acceleration = gravity;

        velocity += ((float)timeDelta / 1000) * acceleration;

        currentPosition = movable.getPosition();

        currentPosition.setY(currentPosition.getY() - velocity * timeDelta);

        if(currentPosition.getY() >= groundY - movableHeight) {
            currentPosition.setY(groundY - movableHeight);
            velocity = 0;
            isMoveBlocked = false;
        }
    }

    public void Jump(){
        if(!isMoveBlocked) {
            velocity = 2.5f;
            isMoveBlocked = true;
        }
    }

    @Override
    public IComponent duplicate() {
        throw new NotLoadedException("There is no such method");
    }

}
