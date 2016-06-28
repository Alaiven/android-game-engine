package com.wp.androidgameengine.engine.objects;

import com.wp.androidgameengine.engine.watchdog.GuardedObject;

public class Texture extends GuardedObject {
    private final Vec2 dimensions;
    private Vec2 position;
    private int textureId;

    public Vec2 getPosition() {
        return position;
    }

    public void setPosition(Vec2 position) {
        this.position = position;
    }

    public float getWidth() {
        return dimensions.getX();
    }

    public void setWidth(float width) {
        this.dimensions.setX(width);
    }

    public float getHeight() {
        return this.dimensions.getY();
    }

    public void setHeight(int height) {
        this.dimensions.setY(height);
    }

    public Vec2 getDimensions() {
        return dimensions;
    }

    public int getTextureId() {
        return textureId;
    }

    public void setTextureId(int textureId) {
        this.textureId = textureId;
    }

    public Texture(Vec2 position, Vec2 dimensions, int textureId) {
        super();
        this.position = position;
        this.dimensions = dimensions;
        this.textureId = textureId;
    }
}
