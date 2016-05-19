package com.wp.androidgameengine.engine.objects;

import com.wp.androidgameengine.engine.watchdog.GuardedObject;

/**
 * Created by Rafał on 19.05.2016.
 */
public class Layer extends GuardedObject {
    private int layerID;
    private float deviceWidth;
    private float deviceHeight;
    private float layerWidth;
    private float layerHeight;
    private Texture textures[];
    private Texture sampleTexture;
    private Boolean dynamicLayerFlag;
    private int TexturesCount;

    public Layer(int layerID, float deviceWidth, float deviceHeight, Texture[] textures, Boolean dynamicLayerFlag) {
        super();
        this.layerID = layerID;
        this.deviceWidth = deviceWidth;
        this.deviceHeight = deviceHeight;
        this.textures = textures;
        this.dynamicLayerFlag = dynamicLayerFlag;

        sampleTexture = textures[0];
        layerWidth = deviceWidth + 4*sampleTexture.getWidth();
        layerHeight = sampleTexture.getHeight();
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

    public Texture[] getTextures() {
        return textures;
    }

    public void setTextures(Texture[] textures) {
        this.textures = textures;
    }

    public Texture getSampleTexture() {
        return sampleTexture;
    }

    public void setSampleTexture(Texture sampleTexture) {
        this.sampleTexture = sampleTexture;
    }
    public Boolean getDynamicLayerFlag() {
        return dynamicLayerFlag;
    }

    public void setDynamicLayerFlag(Boolean dynamicLayerFlag) {
        this.dynamicLayerFlag = dynamicLayerFlag;
    }
}
