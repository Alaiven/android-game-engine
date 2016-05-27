package com.wp.androidgameengine.engine.objects;

import com.wp.androidgameengine.engine.threads.ThreadCommunicator;
import com.wp.androidgameengine.engine.watchdog.collections.GuardedLinkedList;

import java.util.Queue;

/**
 * Created by Rafał on 27.05.2016.
 */
public class StaticLayer extends Layer {

    public Queue<TextureLayer> myQueue = new GuardedLinkedList<TextureLayer>();

    public StaticLayer(int layerID, float deviceWidth, float deviceHeight, float layerWidth, float layerHeight, TextureLayer[] textures, float pxMS) {
        super(layerID, deviceWidth, deviceHeight, layerWidth, layerHeight, textures, pxMS);

        for(int i=0; i <textures.length; i++)
            myQueue.offer(textures[i]);
    }

    @Override
    protected void onUpdate(long timeDelta, ThreadCommunicator tc) {

    }
}
