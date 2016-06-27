package com.wp.androidgameengine.engine.objects;

import com.wp.androidgameengine.engine.watchdog.GuardedObject;

public class Texture extends GuardedObject {
    private float x;
    private float y;
    private int width;
    private int height;
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

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getTextureId() {
        return textureId;
    }

    public void setTextureId(int textureId) {
        this.textureId = textureId;
    }

    public Texture(float x, float y, int width, int height, int textureId) {
        super();
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.textureId = textureId;
    }
}
