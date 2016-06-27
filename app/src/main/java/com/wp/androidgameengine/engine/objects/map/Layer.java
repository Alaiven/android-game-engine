package com.wp.androidgameengine.engine.objects.map;

import com.wp.androidgameengine.engine.objects.GameObject;
import com.wp.androidgameengine.engine.threads.ThreadCommunicator;

/**
 * Created by Rafał on 27.05.2016.
 */
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
    protected abstract void onUpdate(long timeDelta, ThreadCommunicator tc);

    public int getLayerID() {
        return layerID;
    }


}
