package com.wp.androidgameengine.engine.objects.player;


import com.wp.androidgameengine.engine.objects.GameObject;
import com.wp.androidgameengine.engine.objects.Texture;
import com.wp.androidgameengine.engine.objects.components.animation.IAnimable;
import com.wp.androidgameengine.engine.objects.components.IComponent;
import com.wp.androidgameengine.engine.threads.ThreadCommunicator;
import com.wp.androidgameengine.engine.watchdog.collections.GuardedArrayList;

public class Player extends GameObject implements IAnimable {

    {
        components = new GuardedArrayList<>();
    }

    private final GuardedArrayList<IComponent> components;
    private Texture currentTexture;

    private int x,y;

    public Player(int x, int y){
        super();

        this.x = x;
        this.y = y;
    }

    @Override
    protected void onUpdate(long timeDelta, ThreadCommunicator tc) {
        for (IComponent component: components) {
            component.perform(timeDelta);
        }

        setTextureCoordinates();

        tc.Produce(currentTexture);
    }

    private void setTextureCoordinates() {
        currentTexture.setX(x);
        currentTexture.setY(y);
    }

    public void addComponent(IComponent component){
        component.setComposable(this);
        components.add(component);
    }

    @Override
    public void setCurrentAnimationFrame(Texture texture) {
        currentTexture = texture;
    }
}
