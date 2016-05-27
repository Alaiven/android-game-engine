package com.wp.androidgameengine.engine.objects;

import com.wp.androidgameengine.engine.threads.ThreadCommunicator;

/**
 * Created by Rafał on 27.05.2016.
 */
public abstract class Layer extends GameObject {
    private int layerID;
    private float deviceWidth;
    private float deviceHeight;
    private float layerWidth;
    private float layerHeight;
    private TextureLayer textures[];
    private TextureLayer sampleTexture;
    private float pxMS;

    // px/ms
    public Layer(int layerID, float deviceWidth, float deviceHeight, float layerWidth, float layerHeight, TextureLayer[] textures, float pxMS) {
        this.layerID = layerID;
        this.deviceWidth = deviceWidth;
        this.deviceHeight = deviceHeight;
        this.layerWidth = layerWidth;
        this.layerHeight = layerHeight;
        this.textures = textures;
        this.pxMS = pxMS;
        sampleTexture = textures[0];
        layerWidth = deviceWidth + 4*sampleTexture.getWidth();
        layerHeight = sampleTexture.getHeight();
    }

    public float getPxMS() {
        return pxMS;
    }

    public void setPxMS(float pxMS) {
        this.pxMS = pxMS;
    }

    @Override
    protected abstract void onUpdate(long timeDelta, ThreadCommunicator tc);

    public Texture[] getTextures() {
        return textures;
    }

    public void setTextures(TextureLayer[] textures) {
        this.textures = textures;
    }

    public Texture getSampleTexture() {
        return sampleTexture;
    }

    public void setSampleTexture(TextureLayer sampleTexture) {
        this.sampleTexture = sampleTexture;
    }

    public int getLayerID() {
        return layerID;
    }

    public void setLayerID(int layerID) {
        this.layerID = layerID;
    }

    public float getDeviceWidth() {
        return deviceWidth;
    }

    public void setDeviceWidth(float deviceWidth) {
        this.deviceWidth = deviceWidth;
    }

    public float getDeviceHeight() {
        return deviceHeight;
    }

    public void setDeviceHeight(float deviceHeight) {
        this.deviceHeight = deviceHeight;
    }

    public float getLayerWidth() {
        return layerWidth;
    }

    public void setLayerWidth(float layerWidth) {
        this.layerWidth = layerWidth;
    }

    public float getLayerHeight() {
        return layerHeight;
    }

    public void setLayerHeight(float layerHeight) {
        this.layerHeight = layerHeight;
    }
}
