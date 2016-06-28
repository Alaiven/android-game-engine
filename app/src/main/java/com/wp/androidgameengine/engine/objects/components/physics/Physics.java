package com.wp.androidgameengine.engine.objects.components.physics;

import com.wp.androidgameengine.engine.events.Events;
import com.wp.androidgameengine.engine.objects.Position;
import com.wp.androidgameengine.engine.objects.Sound;
import com.wp.androidgameengine.engine.objects.components.IComponent;
import com.wp.androidgameengine.engine.objects.components.IComposable;
import com.wp.androidgameengine.engine.services.SoundService;
import com.wp.androidgameengine.engine.watchdog.GuardedObject;

public class Physics extends GuardedObject implements IComponent {

    private final Sound sound;
    private IMovable movable;
    private int movableHeight;

    private final float gravity = -9.71f;

    private final int groundY;

    public Physics(int groundY, Sound sound){
        super();

        this.groundY = groundY;
        this.sound = sound;
    }

    private float acceleration;
    private float velocity = 0;

    private Position currentPosition;

    private boolean isMoveBlocked = false;

    @Override
    public void perform(long timeDelta, Events e) {

        if(e.isScreenPressed() && !isMoveBlocked){
            velocity = 2.1f;
            isMoveBlocked = true;
            SoundService.getInstance().playSound(sound);
        }

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

    @Override
    public void setComposable(IComposable composable) {
        movable = (IMovable)composable;
        movableHeight = movable.getHeight();
    }
}
