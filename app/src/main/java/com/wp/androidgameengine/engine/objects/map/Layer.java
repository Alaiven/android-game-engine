package com.wp.androidgameengine.engine.objects.map;

import com.wp.androidgameengine.engine.objects.GameObject;
import com.wp.androidgameengine.engine.objects.Vec2;
import com.wp.androidgameengine.engine.threads.ThreadCommunicator;

abstract class Layer extends GameObject {
    private int layerID;
    private MapTexture sampleTexture;

    protected MapTexture textures[];
    protected float pxMS;

    protected final float textureWidth;

    protected final Vec2 position;

    Layer(int layerID, Vec2 position, MapTexture[] textures, float pxMS) {
        this.layerID = layerID;
        this.textures = textures;
        this.pxMS = pxMS;
        sampleTexture = textures[0];

        this.position = position;

        textureWidth = sampleTexture.getWidth();
    }

    @Override
    protected abstract void onUpdate(long timeDelta, ThreadCommunicator tc);

    public int getLayerID() {
        return layerID;
    }


}
