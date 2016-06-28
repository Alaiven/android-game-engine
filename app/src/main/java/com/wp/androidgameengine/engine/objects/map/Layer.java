package com.wp.androidgameengine.engine.objects.map;

import com.wp.androidgameengine.engine.events.Events;
import com.wp.androidgameengine.engine.objects.GameObject;
import com.wp.androidgameengine.engine.threads.ThreadCommunicator;

public abstract class Layer extends GameObject {
    private int layerID;
    private MapTexture sampleTexture;

    protected MapTexture textures[];
    protected float pxMS;

    protected final int textureWidth, layerX, layerY;

    public Layer(int layerID, int x, int y, MapTexture[] textures, float pxMS) {
        this.layerID = layerID;
        this.textures = textures;
        this.pxMS = pxMS;
        sampleTexture = textures[0];

        layerX = x;
        layerY = y;

        textureWidth = sampleTexture.getWidth();
    }

    @Override
    protected abstract void onUpdate(long timeDelta, ThreadCommunicator tc, Events e);

    public int getLayerID() {
        return layerID;
    }


}
