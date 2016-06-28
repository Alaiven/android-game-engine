package com.wp.androidgameengine.engine.objects.player;


import com.wp.androidgameengine.engine.events.Events;
import com.wp.androidgameengine.engine.objects.GameObject;
import com.wp.androidgameengine.engine.objects.Position;
import com.wp.androidgameengine.engine.objects.Texture;
import com.wp.androidgameengine.engine.objects.components.animation.IAnimable;
import com.wp.androidgameengine.engine.objects.components.IComponent;
import com.wp.androidgameengine.engine.objects.components.physics.IMovable;
import com.wp.androidgameengine.engine.threads.ThreadCommunicator;
import com.wp.androidgameengine.engine.watchdog.collections.GuardedArrayList;

public class Player extends GameObject implements IAnimable, IMovable {

    {
        components = new GuardedArrayList<>();
    }

    private final GuardedArrayList<IComponent> components;
    private Texture currentTexture;

    private Position position;

    public Player(Position p){
        super();

        this.position = p;
    }

    @Override
    protected void onUpdate(long timeDelta, ThreadCommunicator tc, Events e) {
        for (IComponent component: components) {
            component.perform(timeDelta, e);
        }

        setTextureCoordinates();

        tc.Produce(currentTexture);
    }

    private void setTextureCoordinates() {
        currentTexture.setPosition(position);
    }

    public void addComponent(IComponent component){
        component.setComposable(this);
        components.add(component);
    }

    @Override
    public void setCurrentAnimationFrame(Texture texture) {
        currentTexture = texture;
    }


    @Override
    public void setCurrentPosition(Position p) {
        this.position = p;
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    @Override
    public int getHeight() {
        return 128;
    }
}
