package com.wp.androidgameengine.engine.objects.map;

import com.wp.androidgameengine.engine.objects.Vec2;
import com.wp.androidgameengine.engine.threads.ThreadCommunicator;
import com.wp.androidgameengine.engine.watchdog.collections.GuardedLinkedList;

import java.util.Queue;

public class StaticLayer extends Layer {

    public Queue<MapTexture> myQueue = new GuardedLinkedList<MapTexture>();

    public StaticLayer(int layerID, MapTexture[] textures, float pxMS) {
        super(layerID, new Vec2(0, 0), textures, pxMS);

        for(int i=0; i <textures.length; i++)
            myQueue.offer(textures[i]);
    }

    @Override
    protected void onUpdate(long timeDelta, ThreadCommunicator tc) {

    }
}
