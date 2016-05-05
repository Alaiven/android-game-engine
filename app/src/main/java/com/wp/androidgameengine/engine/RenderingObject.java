package com.wp.androidgameengine.engine;

import com.wp.androidgameengine.engine.watchdog.GuardedObject;

/**
 * Created by maciek on 20.04.16.
 *
 * Dummy object for further development, aimed for storing data needed for rendering.
 */
public class RenderingObject extends GuardedObject {
    private float x;
    private float y;
    private float width;
    private float height;
    private int textureId;

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public int getTextureId() {
        return textureId;
    }

    public void setTextureId(int textureId) {
        this.textureId = textureId;
    }

    public RenderingObject(float x, float y, float width, float height, int textureId) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.textureId = textureId;
    }
}
