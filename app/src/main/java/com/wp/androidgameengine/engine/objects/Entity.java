package com.wp.androidgameengine.engine.objects;

import com.wp.androidgameengine.engine.objects.components.IComponent;
import com.wp.androidgameengine.engine.objects.components.movable.IMovable;
import com.wp.androidgameengine.engine.objects.enemy.Enemy;
import com.wp.androidgameengine.engine.threads.ThreadCommunicator;
import com.wp.androidgameengine.engine.watchdog.collections.GuardedArrayList;

public abstract class Entity extends GameObject implements IMovable {

    private final Vec2 dimensions;

    {
        components = new GuardedArrayList<>();
    }

    protected GuardedArrayList<IComponent> components;
    protected Texture currentTexture;

    protected Vec2 position;

    public Entity(Vec2 position, Vec2 dimensions){
        this.position = position.duplicate();
        this.dimensions = dimensions;
    }

    protected void onUpdate(long timeDelta, ThreadCommunicator tc) {
        for (IComponent component: components) {
            component.perform(this, timeDelta);
        }

        setTextureCoordinates();

        customUpdate(timeDelta, tc);

        tc.Produce(currentTexture);
    }

    protected abstract void customUpdate(long timeDelta, ThreadCommunicator tc);

    private void setTextureCoordinates() {
        currentTexture.setPosition(this.position);
    }

    public void addComponent(IComponent component){
        components.add(component);
    }

    public Vec2 getPosition() {
        return position;
    }

    public void setPosition(Vec2 position) {
        this.position.setX(position.getX());
        this.position.setY(position.getY());
    }

    public Vec2 getDimensions() {
        return dimensions;
    }

    protected GuardedArrayList<IComponent> getComponents(){
        return components;
    }

    protected void copyProtected(Enemy enemy) {
        for(IComponent component: enemy.getComponents()){
            addComponent(component.duplicate());
        }

    }
}
