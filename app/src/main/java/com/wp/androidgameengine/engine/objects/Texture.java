package com.wp.androidgameengine.engine.objects;

import com.wp.androidgameengine.engine.watchdog.GuardedObject;

public class Texture extends GuardedObject {
    private Position position;
    private int width;
    private int height;
    private int textureId;

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
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

    public Texture(Position p, int width, int height, int textureId) {
        super();
        this.position = p;
        this.width = width;
        this.height = height;
        this.textureId = textureId;
    }
}
