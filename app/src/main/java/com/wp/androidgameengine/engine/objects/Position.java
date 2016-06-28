package com.wp.androidgameengine.engine.objects;

import com.wp.androidgameengine.engine.watchdog.GuardedObject;

public class Position extends GuardedObject {

    private float x, y;

    public Position(float x, float y){
        super();

        this.x = x;
        this.y = y;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }
}
