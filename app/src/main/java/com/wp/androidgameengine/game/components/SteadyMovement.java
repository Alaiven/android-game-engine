package com.wp.androidgameengine.game.components;

import com.wp.androidgameengine.engine.objects.Vec2;
import com.wp.androidgameengine.engine.objects.components.IComponent;
import com.wp.androidgameengine.engine.objects.components.IComposable;
import com.wp.androidgameengine.engine.objects.components.movable.IMovable;
import com.wp.androidgameengine.engine.watchdog.GuardedObject;


public class SteadyMovement extends GuardedObject implements IComponent {

    private final float pxMs;
    private IMovable movable;

    public SteadyMovement(float pxMs){
        super();
        this.pxMs = pxMs;
    }

    private Vec2 position;
    private float pixelsToMove;


    @Override
    public void perform(IComposable composable, long timeDelta) {
        this.movable = (IMovable)composable;

        pixelsToMove = timeDelta * pxMs;

        position = movable.getPosition();
        position.setX(position.getX() - pixelsToMove);
        movable.setPosition(position);
    }

    @Override
    public IComponent duplicate() {
        return this;
    }
}
